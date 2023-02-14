package com.deni.app.module.user.repo;

import com.deni.app.module.user.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserReportRepo {
    public List<UserDTO> getUserList() {
        List<UserDTO> list = new ArrayList<>();
        list.add(UserDTO.builder().id(1L).username("admin").password("*****").roles("ADMIN,USER").permissions("READ,WRITE").active(1).blocked(0).createdDate(new Date()).createdBy("admin").updatedDate(new Date()).updatedBy("admin").build());

        list.add(UserDTO.builder().id(2L).username("user").password("*****").roles("USER").permissions("READ").active(1).blocked(0).createdDate(new Date()).createdBy("admin").updatedDate(new Date()).updatedBy("admin").build());

        list.add(UserDTO.builder().id(3L).username("deni").password("*****").roles("USER").permissions("READ").active(1).blocked(0).createdDate(new Date()).createdBy("admin").updatedDate(new Date()).updatedBy("admin").build());

        list.add(UserDTO.builder().id(4L).username("setiawan").password("*****").roles("USER").permissions("READ").active(1).blocked(0).createdDate(new Date()).createdBy("admin").updatedDate(new Date()).updatedBy("admin").build());

        list.add(UserDTO.builder().id(5L).username("manager").password("*****").roles("MANAGER").permissions("READ,WRITE,DROP").active(1).blocked(0).createdDate(new Date()).createdBy("admin").updatedDate(new Date()).updatedBy("admin").build());
        return list;
    }


}
