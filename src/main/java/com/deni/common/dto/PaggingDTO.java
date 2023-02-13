package com.deni.common.dto;



import com.deni.common.constants.Constants;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaggingDTO {
    private Object content;
    private PageableValueDTO pageable;

    //public PaggingDTO of(Page<User> pagedResult, Object listDTO, String sortBy, String sortType) {
    public PaggingDTO of(int pageNumber, int pageSize, Long totalElement, Object listDTO, String sortBy, String sortType) {
        return PaggingDTO.builder()
                .content(listDTO)
                .pageable(PageableValueDTO.builder()
                        .pageNumber(pageNumber)
                        .rowSize(pageSize)
                        .totalSize(totalElement)
                        .sort(PageableSortDTO.builder()
                                .sortBy(sortBy)
                                .sortType(sortType)
                                .info(Constants.SORT_INFO)
                                .build())
                        .build())
                .build();
    }

}
