package com.varchar6.petcast.serviceothers.domain.notice.command.application.dto.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NoticeWriteRequestDTO {
    private String title;
    private String content;
    private String memberId;
    private boolean fixed;
}
