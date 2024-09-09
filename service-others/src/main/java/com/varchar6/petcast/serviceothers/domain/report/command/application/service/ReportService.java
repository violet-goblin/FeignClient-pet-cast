package com.varchar6.petcast.serviceothers.domain.report.command.application.service;

import com.varchar6.petcast.serviceothers.domain.report.command.application.dto.request.ReportCreateRequestDTO;

public interface ReportService {
    int insertReport(ReportCreateRequestDTO reportCreateRequestDTO);
}
