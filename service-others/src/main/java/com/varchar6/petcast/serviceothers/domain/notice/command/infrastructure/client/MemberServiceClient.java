package com.varchar6.petcast.serviceothers.domain.notice.command.infrastructure.client;

import com.varchar6.petcast.serviceothers.common.response.ResponseMessage;
import com.varchar6.petcast.serviceothers.config.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name="petcast-member-service", url="localhost:8000", configuration = FeignClientConfiguration.class)
public interface MemberServiceClient {

    @PostMapping("/service-member/api/v1/members/search-member-role")
//    List<ResponseMemberRole> searchMemberRole(@RequestHeader("X-Member-Id") String id);
//    List<ResponseMemberRole> searchMemberRole(Map<String, String> map);
    ResponseEntity<ResponseMessage> searchMemberRole(Map<String, String> map);
}
