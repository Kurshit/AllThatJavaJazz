package com.kurshit.Raw;

import java.io.Serializable;

public class Emp implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Emp [name=" + name + ", id=" + ", sal=" + sal + ", age=" +age+ "]";
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	String name;
	int sal, age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Emp(String name, int id, int sal, int age) {
		super();
		this.name = name;
	//	this.id = id;
		this.sal = sal;
	}
	
	
	
	
	

}
