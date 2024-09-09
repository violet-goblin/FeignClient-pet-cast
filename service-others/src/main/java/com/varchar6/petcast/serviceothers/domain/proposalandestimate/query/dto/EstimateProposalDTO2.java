package com.varchar6.petcast.serviceothers.domain.proposalandestimate.query.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class EstimateProposalDTO2 {
    private int id;
    private int expectedCost;
    private EstimateStatus status;
    private String createdAt;
    private String updatedAt;
    private boolean active;
    private int companyId;

    private ProposalDTO proposal;
}
