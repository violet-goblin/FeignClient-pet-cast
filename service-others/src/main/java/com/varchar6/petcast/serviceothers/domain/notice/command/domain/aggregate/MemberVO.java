package com.varchar6.petcast.serviceothers.domain.notice.command.domain.aggregate;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private int id;
    private List<RoleVO> roleVOList;
}