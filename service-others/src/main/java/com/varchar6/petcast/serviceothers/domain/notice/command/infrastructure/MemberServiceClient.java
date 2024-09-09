package com.varchar6.petcast.serviceothers.domain.notice.command.infrastructure;

import com.varchar6.petcast.serviceothers.common.response.ResponseMessage;
import com.varchar6.petcast.serviceothers.config.FeignClientConfiguration;
import com.varchar6.petcast.serviceothers.domain.notice.command.domain.aggregate.ResponseMemberRole;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

@FeignClient(name="petcast-member-service", url="localhost:8000", configuration = FeignClientConfiguration.class)
public interface MemberServiceClient {

    @PostMapping("/service-member/api/v1/members/search-member-role")
//    List<ResponseMemberRole> searchMemberRole(@RequestHeader("X-Member-Id") String id);
//    List<ResponseMemberRole> searchMemberRole(Map<String, String> map);
    ResponseEntity<ResponseMessage> searchMemberRole(Map<String, String> map);
}
