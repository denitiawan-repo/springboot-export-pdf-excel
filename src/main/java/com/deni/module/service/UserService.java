package com.deni.module.service;

import com.deni.module.dto.UserDTO;
import com.deni.exportdoc.common.ReportUtils;
import com.deni.exportdoc.service.UserExportToExcelService;
import com.deni.exportdoc.service.UserExportToPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserExportToPdfService userExportToPdfService;

    @Autowired
    UserExportToExcelService userExportToExcelService;


    @Autowired
    ReportUtils reportUtils;

    public void exportToPdf(HttpServletResponse response) throws IOException {
        // get all user
        List<UserDTO> data = getAllUser();

        // export to pdf
        userExportToPdfService.exportToPDF(response, data);
    }


    public void exportToExcel(HttpServletResponse response) throws IOException {
        // get all user
        List<UserDTO> data = getAllUser();

        // export to pdf
        userExportToExcelService.exportToExcel(response, data);

    }


    public List<UserDTO> getAllUser() {

        List<UserDTO> list = new ArrayList<>();
        list.add(UserDTO.builder().id(1L).username("admin").password("*****").roles("ADMIN,USER").permissions("READ,WRITE").active(1).blocked(0).createdDate(new Date()).createdBy("admin").updatedDate(new Date()).updatedBy("admin").build());

        list.add(UserDTO.builder().id(2L).username("user").password("*****").roles("USER").permissions("READ").active(1).blocked(0).createdDate(new Date()).createdBy("admin").updatedDate(new Date()).updatedBy("admin").build());

        list.add(UserDTO.builder().id(3L).username("deni").password("*****").roles("USER").permissions("READ").active(1).blocked(0).createdDate(new Date()).createdBy("admin").updatedDate(new Date()).updatedBy("admin").build());

        list.add(UserDTO.builder().id(4L).username("tating").password("*****").roles("USER").permissions("READ").active(1).blocked(0).createdDate(new Date()).createdBy("admin").updatedDate(new Date()).updatedBy("admin").build());

        list.add(UserDTO.builder().id(5L).username("adnan").password("*****").roles("MANAGER").permissions("READ,WRITE,DROP").active(1).blocked(0).createdDate(new Date()).createdBy("admin").updatedDate(new Date()).updatedBy("admin").build());
        return list;

    }
}
