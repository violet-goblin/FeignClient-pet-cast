package com.varchar6.petcast.serviceothers.domain.gather.command.application.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ResponseDeactiveGatherDTO {
    private int userId;
    private int gatherId;
}
