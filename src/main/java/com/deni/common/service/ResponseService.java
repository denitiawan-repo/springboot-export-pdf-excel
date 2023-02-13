package com.deni.common.service;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseService {

    boolean success ;
    String message ;
    Object data;
}
