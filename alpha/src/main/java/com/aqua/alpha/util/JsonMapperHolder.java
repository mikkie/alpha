/**
 * 
 */
package com.aqua.alpha.util;

import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author xiaxue
 *
 */
public class JsonMapperHolder {
	
	private static ObjectMapper jsonMapper = new ObjectMapper();
	
	public static String toJson(Map<String, Object> map){
		
		try {
			return jsonMapper.writeValueAsString(map);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
