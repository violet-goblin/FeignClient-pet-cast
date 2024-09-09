package com.varchar6.petcast.serviceothers.domain.notice.command.domain.aggregate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class RoleVO {
    private String name;
    private boolean active;
}
