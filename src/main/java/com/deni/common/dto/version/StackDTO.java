package com.deni.common.dto.version;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StackDTO {


    String name;


    String version;
}
