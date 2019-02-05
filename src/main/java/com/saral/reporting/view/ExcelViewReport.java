package com.saral.reporting.view;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ExcelViewReport extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"reportfile.xls\"");

		
		// List<ApplInfoJson> appInfJsns = (List<ApplInfoJson>)
		// model.get("applInfoJsonForExcel");

		JSONArray output = (JSONArray) model.get("applInfoJsonForExcel");
		Sheet sheet = workbook.createSheet("Report Detail");
		Row header = sheet.createRow(0);
		
		JSONObject json = output.getJSONObject(0);
		@SuppressWarnings("unchecked")
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
		    @SuppressWarnings("unchecked")
			Iterator<String> keys2 = json2.keys();

		    int k = 0;
		    while (keys2.hasNext()) {
		        String key2 = keys2.next();
		        Object val = json2.get(key2);
		        jsnRow.createCell(k).setCellValue(val.toString());
		        k++;
		    }
		}
		
		//workbook.save("FinancialKPI.pdf", SaveFileFormat.Pdf);	
		
		/*ExcelDocument excelDoc = new ExcelDocument("input.xlsx", new ExcelConvertOptions());
		 
		// Save the document as a PDF file
		excelDoc.saveAsPDF("output.pdf");*/
		
	}
}
