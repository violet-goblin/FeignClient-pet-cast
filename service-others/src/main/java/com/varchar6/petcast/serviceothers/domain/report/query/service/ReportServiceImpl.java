package com.varchar6.petcast.serviceothers.domain.report.query.service;

import com.varchar6.petcast.serviceothers.common.response.ResponseMessage;
import com.varchar6.petcast.serviceothers.infrastructure.client.MemberServiceClient;
import com.varchar6.petcast.serviceothers.domain.report.query.dto.ReportDTO;
import com.varchar6.petcast.serviceothers.domain.report.query.mapper.ReportMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service(value="queryReportService")
public class ReportServiceImpl implements ReportService{
    private final ReportMapper reportMapper;
    MemberServiceClient memberServiceClient;

    @Autowired
    public ReportServiceImpl(ReportMapper reportMapper, MemberServiceClient memberServiceClient) {
        this.reportMapper = reportMapper;
        this.memberServiceClient = memberServiceClient;
    }

    @Override
    @Transactional
    public List<ReportDTO> getAllReports(String memberId) throws IllegalAccessException {
        boolean flag = false;

        Map<String, String> map = new HashMap<>();
        map.put("memberId", memberId);

        ResponseEntity<ResponseMessage> message = memberServiceClient.searchMemberRole(map);

        List test= (List) message.getBody().getResult();

        Map<String, String> roleList = new HashMap<>();
        // Message 객체가 Map<String, Object> 형태라면 캐스팅 후 접근

        for(Object getRole : test){

            roleList = (Map<String, String>) getRole;

            String roleCheck = (String) roleList.get("name");

            if(roleCheck.equals("ROLE_ADMIN")){
                flag = true;
                break;
            }
        }

        if (!flag)
            throw new IllegalAccessException("관리자가 아닙니다.");


        return reportMapper.selectAllReports();
    }

    @Override
    @Transactional
    public List<ReportDTO> getReportByReporterId(Integer reporterId, String memberId) throws IllegalAccessException {
        boolean flag = false;

        Map<String, String> map = new HashMap<>();
        map.put("memberId", memberId);

        ResponseEntity<ResponseMessage> message = memberServiceClient.searchMemberRole(map);

        List test= (List) message.getBody().getResult();

        Map<String, String> roleList = new HashMap<>();
        // Message 객체가 Map<String, Object> 형태라면 캐스팅 후 접근

        for(Object getRole : test){

            roleList = (Map<String, String>) getRole;

            String roleCheck = (String) roleList.get("name");

            if(roleCheck.equals("ROLE_ADMIN")){
                flag = true;
                break;
            }
        }

        if (!flag)
            throw new IllegalAccessException("관리자가 아닙니다.");


        return reportMapper.selectReportByReporterId(reporterId);
    }

    @Override
    @Transactional
    public List<ReportDTO> getReportByRespondentId(Integer respondentId, String memberId) throws IllegalAccessException {
        boolean flag = false;

        Map<String, String> map = new HashMap<>();
        map.put("memberId", memberId);

        ResponseEntity<ResponseMessage> message = memberServiceClient.searchMemberRole(map);

        List test= (List) message.getBody().getResult();

        Map<String, String> roleList = new HashMap<>();
        // Message 객체가 Map<String, Object> 형태라면 캐스팅 후 접근

        for(Object getRole : test){

            roleList = (Map<String, String>) getRole;

            String roleCheck = (String) roleList.get("name");

            if(roleCheck.equals("ROLE_ADMIN")){
                flag = true;
                break;
            }
        }

        if (!flag)
            throw new IllegalAccessException("관리자가 아닙니다.");


        return reportMapper.selectReportByRespondentId(respondentId);
    }
}
