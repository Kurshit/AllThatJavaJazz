package com.kurshit.Collections;

import java.util.HashMap;

public class EqualsAndHashCode {

	static HashMap<Employee,Employee> hm = new HashMap<Employee,Employee>();
	
	public static HashMap<Employee,Employee> loadHashMap()
	{
		
		
		Employee e1 = new Employee("758039","30061992");
		Employee e2 = new Employee("1234","08082002");
		Employee e3 = new Employee("5678","10052000");
		Employee e4 = new Employee("758039","30061992");
		
		hm.put(e1, e1);
		hm.put(e2, e2);
		hm.put(e3, e3);
		hm.put(e4, e4);
				
		return hm;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		loadHashMap();
		
		System.out.println(hm.get(new Employee("758039","30061992")));
		
		
		
	}

}

class Employee
{
	String name, dob;
	
	Employee(String name, String dob)
	{
		this.name = name;
		this.dob = dob;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String toString()
	{
		return this.name + "  " + this.dob + "  ";
				
	}
	
}
