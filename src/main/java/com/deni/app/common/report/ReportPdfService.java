package com.deni.app.common.report;

import com.lowagie.text.pdf.PdfPTable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ReportPdfService {
    void exportToPDF(HttpServletResponse response, Object data) throws IOException;


    void writeTableData(PdfPTable table, Object data);
}
