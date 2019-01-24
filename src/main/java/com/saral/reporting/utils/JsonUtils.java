package com.saral.reporting.utils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	
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


