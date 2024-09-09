package com.varchar6.petcast.serviceothers.domain.proposalandestimate.query.dto;

import com.varchar6.petcast.serviceothers.domain.proposalandestimate.command.domain.aggregate.EstimatesStatus;
import lombok.Data;

@Data
public class EstimateResponseDTO {
    private int id;
    private int expectedCost;
    private String createdAt;
    private String updatedAt;
    private EstimatesStatus status;
    private boolean active;


}
