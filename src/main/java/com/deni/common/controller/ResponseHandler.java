package com.deni.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static ResponseEntity response2xx(String message, Object data) {
        return new ResponseEntity<>(
                new Response(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.toString(),
                        message,
                        data),
                HttpStatus.OK);
    }

    public static ResponseEntity response4xx(String message, Object data) {
        return new ResponseEntity<>(
                new Response(
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.toString(),
                        message,
                        data),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity init() {
        return new ResponseEntity<>(
                new Response(
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.toString(),
                        HttpStatus.NOT_FOUND.toString(),
                        ""),
                HttpStatus.NOT_FOUND);
    }

}
