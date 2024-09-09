package com.varchar6.petcast.serviceothers.domain.gather.command.application.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class RequestDeactiveGatherDTO {
    private int userId;
    private int gatherId;
}
