package com.deni.app.common.report;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ReportExcelService {
    void exportToExcel(HttpServletResponse response, Object data) throws IOException;

}
