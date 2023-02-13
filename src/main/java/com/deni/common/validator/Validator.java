package com.deni.common.validator;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Validator {

    boolean success;
    String message;

    public Validator yes() {
        return Validator.builder()
                .success(true)
                .message(String.valueOf(""))
                .build();
    }

    public Validator yes(String message) {
        return Validator.builder()
                .success(true)
                .message(message)
                .build();
    }

    public Validator no(String message) {
        return Validator.builder()
                .success(false)
                .message(message)
                .build();
    }
}
