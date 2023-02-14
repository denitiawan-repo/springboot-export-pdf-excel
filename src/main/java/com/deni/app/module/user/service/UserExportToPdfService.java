package com.deni.app.module.user.service;

import com.deni.app.module.user.dto.UserDTO;
import com.deni.app.common.report.ReportAbstract;
import com.deni.app.common.report.ReportPdfService;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class UserExportToPdfService extends ReportAbstract implements ReportPdfService {

    public void writeTableData(PdfPTable table, Object data) {
        List<UserDTO> list = (List<UserDTO>) data;

        // for auto wide by paper  size
        table.setWidthPercentage(100);
        // cell
        PdfPCell cell = new PdfPCell();
        int number = 0;
        for (UserDTO item : list) {
            number += 1;
            cell.setPhrase(new Phrase(String.valueOf(number), getFontContent()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(item.getUsername(), getFontContent()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(item.getRoles(), getFontContent()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(item.getPermissions(), getFontContent()));
            table.addCell(cell);

            String active = item.getActive() == 1 ? "Active" : "Non Active";
            cell.setPhrase(new Phrase(active, getFontContent()));
            table.addCell(cell);

            String blocked = item.getBlocked() == 1 ? "Blocked" : "Non Blocked";
            cell.setPhrase(new Phrase(blocked, getFontContent()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(item.getCreatedBy(), getFontContent()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(item.getCreatedDate().toString(), getFontContent()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(item.getUpdatedBy(), getFontContent()));
            table.addCell(cell);

            cell.setPhrase(new Phrase(item.getUpdatedDate().toString(), getFontContent()));
            table.addCell(cell);
        }

    }


    public void exportToPDF(HttpServletResponse response, Object data) throws IOException {


        // init respose
        response = initResponseForExportPdf(response, "USER");

        // define paper size
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        // start document
        document.open();

        // title
        Paragraph title = new Paragraph("Report User", getFontTitle());
        title.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(title);

        // subtitel
        Paragraph subtitel = new Paragraph("Report Date : 09/12/2022", getFontSubtitle());
        subtitel.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(subtitel);

        enterSpace(document);

        // table header
        String[] headers = new String[]{"No", "username", "Roles", "Permission", "Active", "Bloked", "Created By", "Created Date", "Update By", "Update Date"};
        PdfPTable tableHeader = new PdfPTable(10);
        writeTableHeaderPdf(tableHeader, headers);
        document.add(tableHeader);

        // table content
        PdfPTable tableData = new PdfPTable(10);
        writeTableData(tableData, data);
        document.add(tableData);

        document.close();
    }

}
