package com.varchar6.petcast.serviceothers.domain.proposalandestimate.command.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class EstimatesRequestDTO {
    private int expectedCost;
    private String createdAt;
    private int proposalId;
    private int companyId;

}
