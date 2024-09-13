package com.varchar6.petcast.serviceothers.common.util;

import lombok.*;
import org.springframework.data.domain.Pageable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestList<T> {
    private T data;
    private Pageable pageable;
}
