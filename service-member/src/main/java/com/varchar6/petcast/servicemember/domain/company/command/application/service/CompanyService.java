package com.varchar6.petcast.servicemember.domain.company.command.application.service;

import com.varchar6.petcast.servicemember.domain.company.command.application.dto.request.CompanyEnrollRequestDTO;
import com.varchar6.petcast.servicemember.domain.company.command.application.dto.response.CompanyResponseDTO;

public interface CompanyService {
    CompanyResponseDTO applyEnroll(CompanyEnrollRequestDTO companyEnrollRequestDTO);
    void deleteCompanyById(int companyId);

    void approveCompany(int companyId);

    void deactivateCompany(int companyId);
}
