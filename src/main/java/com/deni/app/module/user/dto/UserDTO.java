package com.deni.app.module.user.dto;

import lombok.*;

import java.util.Date;


/**
 * Created by Deni Setiawan on 08/12/2022.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    Long id;
    String username;
    String password;
    String roles;
    String permissions;
    Integer blocked;
    Integer active;


    String createdBy;
    Date createdDate;
    String updatedBy;
    Date updatedDate;

}
