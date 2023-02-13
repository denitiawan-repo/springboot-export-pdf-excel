package com.deni.common.dto.version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VersionStackDTO {
    StackDTO language;
    StackDTO database;
    StackDTO searchengine;
}
