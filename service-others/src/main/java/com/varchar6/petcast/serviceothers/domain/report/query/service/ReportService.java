package com.varchar6.petcast.serviceothers.domain.report.query.service;

import com.varchar6.petcast.serviceothers.domain.report.query.dto.ReportDTO;

import java.util.List;

public interface ReportService {
    List<ReportDTO> getAllReports(String memberId) throws IllegalAccessException;

    List<ReportDTO> getReportByReporterId(Integer reporterId, String memberId) throws IllegalAccessException;

    List<ReportDTO> getReportByRespondentId(Integer respondentId, String memberId) throws IllegalAccessException;
}
