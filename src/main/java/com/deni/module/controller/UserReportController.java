package com.deni.module.controller;

import com.deni.common.controller.ResponseHandler;
import com.deni.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/v1/report/user")
public class UserReportController {
    ResponseEntity responseEntity = ResponseHandler.init();
    @Autowired
    UserService userService;

    @GetMapping("/pdf/all")
    public void exportToPdf(HttpServletResponse response) throws IOException {
        this.userService.exportToPdf(response);
    }


    @GetMapping("/excel/all")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        this.userService.exportToExcel(response);
    }
}
