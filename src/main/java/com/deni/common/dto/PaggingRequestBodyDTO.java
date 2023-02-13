package com.deni.common.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaggingRequestBodyDTO {

    private Integer pageNumber;
    private Integer rowSize;
    private String sortBy;
    private String sortType;

}
