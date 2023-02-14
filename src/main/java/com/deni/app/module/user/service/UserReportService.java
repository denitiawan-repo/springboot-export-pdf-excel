package com.deni.app.module.user.service;

import com.deni.app.module.user.dto.UserDTO;
import com.deni.app.module.user.repo.UserReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class UserReportService {

    @Autowired
    UserExportToPdfService userExportToPdfService;

    @Autowired
    UserExportToExcelService userExportToExcelService;

    @Autowired
    UserReportRepo userReportRepo;


    public void exportToPdf(HttpServletResponse response) throws IOException {
        // get all user
        List<UserDTO> data = userReportRepo.getUserList();

        // export to pdf
        userExportToPdfService.exportToPDF(response, data);
    }


    public void exportToExcel(HttpServletResponse response) throws IOException {
        // get all user
        List<UserDTO> data = userReportRepo.getUserList();

        // export to pdf
        userExportToExcelService.exportToExcel(response, data);

    }


}
