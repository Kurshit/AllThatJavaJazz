package com.kurshit.Raw;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Concept {
	
	ObjectMapper om;
	
	
	
	public JsonNode mA() throws JsonParseException, JsonMappingException, IOException {
		InputStream is = null;
		try 
		{
			is = new ByteArrayInputStream("Kurshit Kukreja".getBytes());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return om.readValue(is, JsonNode.class);
	
	}

}
