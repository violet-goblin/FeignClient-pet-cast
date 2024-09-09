package com.varchar6.petcast.servicemember.domain.member.query.service;

import com.varchar6.petcast.servicemember.domain.member.query.dto.MemberDTO;
import com.varchar6.petcast.servicemember.domain.member.query.vo.RoleVO;

import java.util.List;

public interface MemberService {
    MemberDTO getMemberInformationById(int memberId);

    Boolean checkDoubleByLoginId(String loginId);

    Boolean checkDoubleByNickName(String nickName);

    String searchLoginIdByNameAndPhone(String name, String phone);

    String checkPasswordByIdAndPassword(int id);

    int checkIdAndPhone(String loginId, String phone);

    List<RoleVO> searchMemberRole(int id);
}
