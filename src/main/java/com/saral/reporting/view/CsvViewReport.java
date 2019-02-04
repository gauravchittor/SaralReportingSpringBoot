package com.saral.reporting.view;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;

public class CsvViewReport {
	
	protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");
		
		JSONArray output;
		output = new JSONArray(model.get("result"));
        System.out.println("sdfksbf");

        File file=new File("fromJSON2.csv");
        System.out.println("jasvdjvsdkv" + file.getAbsolutePath());
        String csv = CDL.toString(output);
        FileUtils.writeStringToFile(file, csv);
        
		System.out.println("Inside second loop where records are greater than 6000 ==== FINAL");
	}

}
