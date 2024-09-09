package com.varchar6.petcast.servicemember.domain.company.query.service;

import com.varchar6.petcast.servicemember.domain.company.query.dto.CategoryResponseDTO;
import com.varchar6.petcast.servicemember.domain.company.query.dto.response.CompanyResponseDTO;

import java.util.List;


public interface CompanyService {
    CategoryResponseDTO getCategories(String companyId);
    CompanyResponseDTO getCompanyInformationByCompanyId(int companyId);

    List<CompanyResponseDTO> getCompanyList();
}
