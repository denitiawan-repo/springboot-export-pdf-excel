package com.deni.common.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableValueDTO {
    private PageableSortDTO sort;
    private Integer pageNumber;
    private Integer rowSize;
    private Long totalSize;

}
