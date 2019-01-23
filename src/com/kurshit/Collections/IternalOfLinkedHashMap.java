package com.kurshit.Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class IternalOfLinkedHashMap {

	public static void main(String[] args) 
	{
		LinkedHashMap<String,String> hm = new LinkedHashMap<String, String>();
		LinkedHashMap<String,String> hm2 = new LinkedHashMap<String, String>(12, 0.75f, true);
		LinkedHashMap<String,String> hm3 = new LinkedHashMap<String, String>(12, 0.75f, false);
		
		HashMap<String, String> shm = new HashMap<String,String>();
		shm.put("sakshu", "new sakshi value");
		shm.put("dikshu", "diksha");
		
		/*hm.put("kuku", "kurshit");
		hm.put("sakshu", "sakshi");
		hm.put("shwetu", "shweta");
		System.out.println(hm);
		hm.put("kuku", "new Value");
		System.out.println(hm);
		hm.putAll(shm);
		System.out.println(hm);
		
		
		hm2.put("kuku", "kurshit");
		hm2.put("sakshu", "sakshi");
		hm2.put("shwetu", "shweta");
		System.out.println(hm2);
		hm2.put("kuku", "new Value");
		System.out.println(hm2);
		
		hm2.putAll(shm);
		System.out.println(hm2);
		*/
		hm3.put("kuku", "kurshit");
		hm3.put("sakshu", "sakshi");
		hm3.put("shwetu", "shweta");
		System.out.println(hm3);
		hm3.put("kuku", "new Value");
		System.out.println(hm3);
		hm3.putAll(shm);
		System.out.println(hm3);

	}

}
