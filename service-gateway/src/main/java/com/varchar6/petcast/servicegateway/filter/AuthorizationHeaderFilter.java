package com.varchar6.petcast.servicegateway.filter;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {

    private final Environment environment;
    private final JwtUtil jwtUtil;

    public AuthorizationHeaderFilter(Environment environment, JwtUtil jwtUtil) {
        super(Config.class);
        this.environment = environment;
        this.jwtUtil = jwtUtil;
    }

    public static class Config {
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {

            ServerHttpRequest request = exchange.getRequest();

            if(!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                return onError(exchange, "No authorization header", HttpStatus.UNAUTHORIZED);
            }

            String BearerToken = request.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            String jwt = BearerToken.substring(7);

            if(!isJwtValid(jwt)){
                return onError(exchange, "Invalid JWT token", HttpStatus.UNAUTHORIZED);
            }


            // JWT에서 사용자 정보 추출
            Claims claims = jwtUtil.parseClaims(jwt);

            if (claims == null) {
                return onError(exchange, "Invalid JWT claims", HttpStatus.UNAUTHORIZED);
            }

            // 필요한 정보 추출
            String memberId = claims.get("jti", String.class);
            String memberLoginId = claims.get("sub", String.class);
            List<String> authorities = claims.get("authorities", List.class);

            String authoritiesHeader = authorities.stream().collect(Collectors.joining(","));
            // 기존 헤더에 값 추가
            HttpHeaders headers = new HttpHeaders();
            headers.addAll(request.getHeaders()); // 기존 헤더 복사
            headers.add("X-Member-Id", memberId);
            headers.add("X-Member-Login-Id", memberLoginId);
            headers.add("X-authorities", authoritiesHeader);

            // 헤더가 올바르게 추가되었는지 확인하는 로깅
            headers.forEach((key, value) -> {
                log.info(String.format("Gateway added header '%s' with value '%s'", key, value));
            });

            ServerHttpRequest modifiedRequest = request.mutate().headers(httpHeaders -> {
                headers.forEach((key, value) -> {
                    httpHeaders.set(key, String.join(",", value)); // 첫 번째 값을 사용하여 헤더에 추가
                });
            }).build();

            ServerWebExchange modifiedExchange = exchange.mutate().request(modifiedRequest).build();


            return chain.filter(modifiedExchange);


        };
    }

    private Mono<Void> onError(ServerWebExchange exchange, String errorMessage, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

    private boolean isJwtValid(String jwt) {
        log.error("[GATEWAY START] isJwtValid() called with: jwt={}", jwt);
        boolean returnValue = true;

        String subject = null;
        try{
            subject = Jwts.parser()
                    .setSigningKey(environment.getProperty("token.secret"))
                    .parseClaimsJws(jwt)
                    .getBody()
                    .getSubject();
        }catch (Exception e){
            e.printStackTrace();
            returnValue = false;
        }

        if(subject == null || subject.isEmpty()){
            returnValue = false;
        }
        log.error("[GATEWAY END] isJwtValid() called with: jwt={}", jwt);
        return returnValue;
    }


}
