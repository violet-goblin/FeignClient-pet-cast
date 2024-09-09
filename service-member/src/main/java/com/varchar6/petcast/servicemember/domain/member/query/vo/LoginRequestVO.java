package com.varchar6.petcast.servicemember.domain.member.query.vo;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestVO {
    private String loginId;
    private String password;
}
