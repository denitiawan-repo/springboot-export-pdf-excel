package com.deni.app.module.user.service;

import com.deni.app.module.user.dto.UserDTO;
import com.deni.app.common.report.ReportAbstract;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class UserExportToExcelService extends ReportAbstract {

    public void writeTableData(Object data) {
        // data
        List<UserDTO> list = (List<UserDTO>) data;

        // font style content
        CellStyle style = getFontContentExcel();

        // starting write on row
        int startRow = 2;

        // write content
        for (UserDTO UserDTO : list) {
            Row row = sheet.createRow(startRow++);
            int columnCount = 0;
            createCell(row, columnCount++, UserDTO.getId(), style);
            createCell(row, columnCount++, UserDTO.getUsername(), style);
            createCell(row, columnCount++, UserDTO.getPassword(), style);
            createCell(row, columnCount++, UserDTO.getRoles(), style);
            createCell(row, columnCount++, UserDTO.getPermissions(), style);
            createCell(row, columnCount++, UserDTO.getActive(), style);
            createCell(row, columnCount++, UserDTO.getBlocked(), style);
            createCell(row, columnCount++, UserDTO.getCreatedBy(), style);
            createCell(row, columnCount++, UserDTO.getCreatedDate().toString(), style);
            createCell(row, columnCount++, UserDTO.getUpdatedBy(), style);
            createCell(row, columnCount++, UserDTO.getUpdatedDate().toString(), style);

        }
    }


    public void exportToExcel(HttpServletResponse response, Object data) throws IOException {
        newReportExcel();

        // response  writer to excel
        response = initResponseForExportExcel(response, "UserExcel");
        ServletOutputStream outputStream = response.getOutputStream();


        // write sheet, title & header
        String[] headers = new String[]{"No", "username", "Password", "Roles", "Permission", "Active", "Bloked", "Created By", "Created Date", "Update By", "Update Date"};
        writeTableHeaderExcel("Sheet User", "Report User", headers);

        // write content row
        writeTableData(data);

        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
