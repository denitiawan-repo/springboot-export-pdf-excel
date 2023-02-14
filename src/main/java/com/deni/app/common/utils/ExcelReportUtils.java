package com.deni.app.common.utils;

import com.deni.app.module.user.dto.UserDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExcelReportUtils {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<UserDTO> userDTOList;

    public ExcelReportUtils(List<UserDTO> UserDTOList) {
        this.userDTOList = UserDTOList;
        workbook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void createHeaderRow() {
        sheet = workbook.createSheet("UserDTO Information");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        createCell(row, 0, "UserDTO Information", style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
        font.setFontHeightInPoints((short) 10);

        row = sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "Username", style);
        createCell(row, 2, "Password", style);
        createCell(row, 3, "Role", style);
        createCell(row, 4, "Permission", style);
        createCell(row, 5, "Active", style);
        createCell(row, 6, "Blocked", style);
        createCell(row, 7, "Created By", style);
    }

    private void writeUserDTOData() {
        int rowCount = 2;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (UserDTO UserDTO : userDTOList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, UserDTO.getId(), style);
            createCell(row, columnCount++, UserDTO.getUsername(), style);
            createCell(row, columnCount++, UserDTO.getPassword(), style);
            createCell(row, columnCount++, UserDTO.getRoles(), style);
            createCell(row, columnCount++, UserDTO.getPermissions(), style);
            createCell(row, columnCount++, UserDTO.getActive(), style);
            createCell(row, columnCount++, UserDTO.getBlocked(), style);
            createCell(row, columnCount++, UserDTO.getCreatedBy(), style);
        }

    }

    public void exportDataToExcel(HttpServletResponse response) throws IOException {



        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + "UserExcel" + "_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);


        createHeaderRow();
        writeUserDTOData();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}