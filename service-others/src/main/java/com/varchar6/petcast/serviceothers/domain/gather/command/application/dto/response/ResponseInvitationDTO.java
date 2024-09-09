package com.varchar6.petcast.serviceothers.domain.gather.command.application.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class ResponseInvitationDTO {
    private int userId;
    private int invitationId;
}
