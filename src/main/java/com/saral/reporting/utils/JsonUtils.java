package com.saral.reporting.utils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	public static void pageModel(ModelMap model, Page<?> pages) {
		int current = pages.getNumber() + 1;
		int begin = Math.max(1, current - 5);
		int end = Math.min(begin + 5, pages.getTotalPages());
		
		model.addAttribute("end", end);
		model.addAttribute("begin", begin);
		model.addAttribute("current", current);
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject mergeJSONObjects(JSONObject obj1, JSONObject obj2) {
		try {
			
			 
			  obj1.putAll(obj2);
			  System.out.print(obj1);
 
		} catch (Exception e) {
			throw new RuntimeException("JSON Exception" + e);
		}
		return obj1;
	}
	
	public  static String StringUtilsAtLast(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == '}') {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}
	
	public  static String StringUtilsAtFirst(String str) {
	    if (str != null && str.length() > 0) {
	        str = str.substring(1);
	    }
	    return str;
	}
	
	public static Map<String, Object> getMapFromString(String str){
		
		final ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> mapFromString = new LinkedHashMap<>();
		try {
		    mapFromString = mapper.readValue(str, new TypeReference<Map<String, Object>>() {
		        });
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return mapFromString;
	}
}


