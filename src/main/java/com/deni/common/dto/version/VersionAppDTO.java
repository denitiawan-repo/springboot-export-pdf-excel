package com.deni.common.dto.version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VersionAppDTO {

    String name; // app name


    String host; // host


    String port; // port


    String version; // app version


    String apiversion; // api version
}
