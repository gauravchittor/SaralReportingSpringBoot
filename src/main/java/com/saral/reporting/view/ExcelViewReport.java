package com.saral.reporting.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.saral.reporting.model.ApplInfoJson;

public class ExcelViewReport extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"reportfile.xls\"");

		@SuppressWarnings("unchecked")
		List<ApplInfoJson> appInfJsns = (List<ApplInfoJson>) model.get("applInfoJsonForExcel");

		Sheet sheet = workbook.createSheet("Report Detail");

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("aid");
		header.createCell(1).setCellValue("appl_info");
		header.createCell(2).setCellValue("application_form_attributes");
		header.createCell(3).setCellValue("enclosure_data");
		header.createCell(4).setCellValue("service_id");

		int rowCount = 1;
		System.out.println("I am here one two three");
		for (ApplInfoJson appInfJsn : appInfJsns) {
			Row jsnRow = sheet.createRow(rowCount++);
			jsnRow.createCell(0).setCellValue(appInfJsn.getAid());
			jsnRow.createCell(1).setCellValue(appInfJsn.getApplInfo());
			jsnRow.createCell(2).setCellValue(appInfJsn.getApplicationFormAttributes());
			jsnRow.createCell(3).setCellValue(appInfJsn.getEnclosureData());
			jsnRow.createCell(4).setCellValue(appInfJsn.getServiceId());
		}

	}
}
