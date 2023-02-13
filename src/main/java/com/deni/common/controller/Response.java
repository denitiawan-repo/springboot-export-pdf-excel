package com.deni.common.controller;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {

    int code;
    String status;
    String message;
    Object data;

}
