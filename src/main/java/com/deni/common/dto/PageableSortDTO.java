package com.deni.common.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableSortDTO {
    private String sortBy;
    private String sortType;
    private String info = "you can using asc or desc value for sortType";
}
