package com.kurshit.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ComparatorExample
{

	public static void main(String[] args)
	{
 		HashMap<String,Object> hm1 = new HashMap<>();
 		hm1.put("id", 1);
 		hm1.put("userId", "user1");
 		
 		HashMap<String,Object> hm2 = new HashMap<>();
 		hm2.put("id", 2);
 		hm2.put("userId", "adminuser1");
 		HashMap<String,Object> hm3 = new HashMap<>();
 		hm3.put("id", 3);
 		hm3.put("userId", "newuser1");
 		HashMap<String,Object> hm4 = new HashMap<>();
 		hm4.put("id", 4);
 		hm4.put("userId", "olduser1");
 		
 		List<HashMap<String,Object>> list = new ArrayList<>();
 		
 		list.add(hm1);
 		list.add(hm2);

 		list.add(hm3);
 		list.add(hm4);
 		
 		//Collections.sort(list, new MyComp()); //this will also work
 		 		
 		/*Collections.sort(list,  new Comparator<HashMap<String,Object>>() {
 			public int compare(HashMap<String,Object> m1, HashMap<String,Object> m2)
 			{
 				return m1.get("userId").toString().compareTo(m2.get("userId").toString());
 			}
 		});*/
 		
 		Collections.sort(list, (HashMap<String,Object> m1, HashMap<String,Object> m2) -> m1.get("userId").toString().compareTo(m2.get("userId").toString()));
 		
 		System.out.println(list);
 		
	}

}

/*class MyComp implements Comparator<HashMap<String,Object>> //this will also work
{

	@Override
	public int compare(HashMap<String, Object> m1, HashMap<String, Object> m2)
	{
		return m1.get("userId").toString().compareTo(m2.get("userId").toString());
	}
	
}
*/
