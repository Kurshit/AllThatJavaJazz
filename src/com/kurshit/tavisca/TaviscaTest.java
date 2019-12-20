package com.kurshit.tavisca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class TaviscaTest {

	public static void main(String[] args) {
		String input = "Chaai,-milk,-water,Coffee";
		
		String[] inputArray = input.split(",");
		
		HashMap<String, List<String>> orders = new HashMap<>();
		
		int i =0;
		int j= 0;
		while(i<inputArray.length) {
			
			String beverage = ""; 
			List<String> contentList = new ArrayList<>();
			
			if(!inputArray[i].startsWith("-")) {
				beverage = inputArray[i];
				i++;
				
				while(i < inputArray.length && inputArray[i].startsWith("-")) {
 					contentList.add(inputArray[i].substring(1));
 					i++;
				}
				
			} 
			
			orders.put(beverage, contentList);
			
		}
		
		System.out.println(orders);
		
		int totalBill = 0;
		BeverageFactory factory = new BeverageFactory();
		for(String item : orders.keySet()) {
			
			Beverage beverage = factory.create(item);
			beverage.exclude(orders.get(item));
			System.out.println(beverage.description());
			totalBill = totalBill + beverage.cost();
			
			
		}
		
		System.out.println(totalBill);
		//c.exclude(orders.get("Chaai"));
		//System.out.println(c.cost());

	}

}

abstract class Beverage {
	
	public String bevName ; 
	
	public abstract String description();		
	
	public abstract int cost();
	
	public void exclude(List<String> list) { };

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bevName == null) ? 0 : bevName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beverage other = (Beverage) obj;
		if (bevName == null) {
			if (other.bevName != null)
				return false;
		} else if (!bevName.equals(other.bevName))
			return false;
		return true;
	}
	
		
	
}

class Chaai extends Beverage {
			
	static List<Content> contentList = new ArrayList<>();
	
	static {
		contentList.add(new Milk());
		contentList.add(new Water());
		contentList.add(new Leaves());
	}
	
	public Chaai() {
		this.bevName = "Chaai";	
		
	}
	
	public void exclude(List<String> excludedList) {
		
		BeverageFactory factory = new BeverageFactory();
		
		for(String item : excludedList) {
			
			contentList.remove(factory.create(item));
		}
	}
	
	public String description() {
		String content = "Chaai contains ";
		
		for(Content c: contentList ) {
			content = content + " " + c.description();
		}
		
		return content;
	}
	
	public int cost() {
		
		int totalCost = 10;
		for(Content content : contentList) {
			totalCost = totalCost + content.cost();
		}
		
		return totalCost;
	}
	
	
}

class Coffee extends Beverage {
	
	static List<Content> contentList = new ArrayList<>();
	
	static {
		contentList.add(new Milk());
		contentList.add(new Water());
		contentList.add(new Leaves());
	}
	
	public Coffee() {
		this.bevName = "Coffee";	
		
	}
	
	public void exclude(List<String> excludedList) {
		
		BeverageFactory factory = new BeverageFactory();
		
		for(String item : excludedList) {
			
			contentList.remove(factory.create(item));
		}
	}
	
	public String description() {
		String content = "Coffee contains ";
		
		for(Content c: contentList ) {
			content = content + " " + c.description();
		}
		
		return content;
	}
	
	public int cost() {
		
		int totalCost = 20;
		for(Content content : contentList) {
			totalCost = totalCost + content.cost();
		}
		
		return totalCost;
	}
	
	
}


abstract class Content extends Beverage {
	
		
	public abstract String description();

	public abstract int cost();
	
	
		
		
}

class Milk extends Content {

	public Milk() {
		this.bevName = "Milk";
	}
	
	public String description() {
		return "Milk";
	}

	public int cost() {
		return 2;
	}
	
}

class Water extends Content {

	public Water() {
		this.bevName = "Water";
	}
	
	public String description() {
		return "Water";
	}

	public int cost() {
		return 4;
	}
	
}

class Leaves extends Content {

	public Leaves() {
		this.bevName = "Leaves";
	}
	
	public String description() {
		return "Leaves";
	}

	public int cost() {
		return 6;
	}
	
}


class BeverageFactory {
	
	public Beverage create(String type) {
		
		if(type.equals("Chaai"))
				return new Chaai();
		else if(type.equals("milk"))
			return new Milk();
		else if(type.equals("water"))
			return new Water();
		else if(type.equals("Coffee"))
			return new Coffee();
		
		return null;
	}
	
}