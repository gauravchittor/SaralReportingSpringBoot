package com.saral.reporting.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.saral.reporting.model.ApplInfoJson;

public class ExcelViewReport extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"reportfile.xls\"");

		@SuppressWarnings("unchecked")
		// List<ApplInfoJson> appInfJsns = (List<ApplInfoJson>)
		// model.get("applInfoJsonForExcel");

		JSONArray output = (JSONArray) model.get("applInfoJsonForExcel");
		Sheet sheet = workbook.createSheet("Report Detail");
		Row header = sheet.createRow(0);
		
		JSONObject json = output.getJSONObject(0);
		Iterator<String> keys = json.keys();
		int i = 0;
		while (keys.hasNext()) {
			String key = keys.next();
			header.createCell(i).setCellValue(key);
			System.out.println(key);
			i++;
		}

		int rowCount = 1;
		System.out.println("I am here one two three");
		
		for (int j = 0; j < output.length(); j++) {
			Row jsnRow = sheet.createRow(rowCount++);
		    JSONObject json2 = output.getJSONObject(j);
		    Iterator<String> keys2 = json.keys();

		    int k = 0;
		    while (keys2.hasNext()) {
		        String key2 = keys2.next();
		        String val = (String) json2.get(key2);
		        jsnRow.createCell(k).setCellValue(val);
		        k++;
		    }

		}
		
		/*header.createCell(0).setCellValue("aid");
		header.createCell(1).setCellValue("appl_info");
		header.createCell(2).setCellValue("application_form_attributes");
		header.createCell(3).setCellValue("enclosure_data");
		header.createCell(4).setCellValue("service_id");*/

	/*	int rowCount = 1;
		System.out.println("I am here one two three");
		for (ApplInfoJson appInfJsn : appInfJsns) {
			Row jsnRow = sheet.createRow(rowCount++);
			jsnRow.createCell(0).setCellValue(appInfJsn.getAid());
			jsnRow.createCell(1).setCellValue(appInfJsn.getApplInfo());
			jsnRow.createCell(2).setCellValue(appInfJsn.getApplicationFormAttributes());
			jsnRow.createCell(3).setCellValue(appInfJsn.getEnclosureData());
			jsnRow.createCell(4).setCellValue(appInfJsn.getServiceId());
		}*/
	}
}
