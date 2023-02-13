package com.deni.exportdoc.common;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ReportExcelService {
    void exportToExcel(HttpServletResponse response, Object data) throws IOException;

}
