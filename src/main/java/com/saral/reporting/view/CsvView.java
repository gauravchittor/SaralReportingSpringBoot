package com.saral.reporting.view;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.saral.reporting.utils.JsonUtils;
import com.saral.reporting.view.AbstractCsvView;
import com.fasterxml.jackson.databind.ObjectMapper;// in play 2.3

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CsvView extends AbstractCsvView {
	@Override
	protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");
		JSONArray output = (JSONArray) model.get("applInfoJsonForCSV");
		ArrayList<String> ar = new ArrayList<String>();

		JSONObject json = output.getJSONObject(0);
		@SuppressWarnings("unchecked")
		Iterator<String> keys = json.keys();
		int i = 0;
		while (keys.hasNext()) {
			String key = keys.next();
			ar.add(key);
			System.out.println(key);
			i++;
		}
		
		String[] header = new String[ar.size()];
		header = ar.toArray(header);
	
		System.out.println("Header is" + header.toString());
		 for (String x : header) 
	            System.out.print(x + " "); 
		 
	/*	 File file=new File(PATH_VARIABLES);
		 System.out.println("jasvdjvsdkv");
	     String csv = CDL.toString(output);
	     FileUtils.writeStringToFile(file, csv);
		 System.out.println(file.getAbsolutePath());*/
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		csvWriter.writeHeader(header);
		List<Object> lst = JsonUtils.toList(output);
		for (Object user : lst) {
            csvWriter.write(user, header);
        }
		csvWriter.close();
	}

}
