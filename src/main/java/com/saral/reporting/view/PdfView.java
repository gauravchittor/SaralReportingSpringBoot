package com.saral.reporting.view;

import com.saral.reporting.view.AbstractPdfView;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"my-pdf-file.pdf\"");
		// TODO Auto-generated method stub

		System.out.println("I am here at first line");
		
		JSONArray output = (JSONArray) model.get("applInfoJsonForExcel");
		document.add(new Paragraph("Generated Report " + LocalDate.now()));
		document.add(new Paragraph("Total Records = " +  output.length()));
		
		System.out.println("I am here at second line");
		
		JSONObject json = output.getJSONObject(0);
		@SuppressWarnings("unchecked")
		Iterator<String> keys = json.keys();
		int i = 0;
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(key);
			i++;
		}

		System.out.println("I am here at third line" + i);
		PdfPTable table = new PdfPTable(i);
		table.setWidthPercentage(100.0f);
		table.setSpacingBefore(10);
		
		// define font for table header row
        Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(BaseColor.WHITE);
        
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setPadding(5);
        System.out.println("I am here at header section");
        // write table header
        Iterator<String> keys3 = json.keys();
		int a = 0;
		while (keys3.hasNext()) {
			String keyNew = keys3.next();
			cell.setPhrase(new Phrase(keyNew, font));
			table.addCell(cell);
			a++;
		}
        
		System.out.println("I am here one two three output.length()");
		
		for (int j = 0; j < output.length(); j++) {
		    JSONObject json2 = output.getJSONObject(j);
		    @SuppressWarnings("unchecked")
			Iterator<String> keys2 = json.keys();
		    while (keys2.hasNext()) {
		        String key2 = keys2.next();
		        Object val = json2.get(key2);
		        table.addCell(val.toString());
		    }

		}
		
		document.add(table);
        
	}

}
