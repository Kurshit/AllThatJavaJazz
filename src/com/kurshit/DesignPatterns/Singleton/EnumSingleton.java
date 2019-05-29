package com.kurshit.DesignPatterns.Singleton;

public enum EnumSingleton {
	
	INSTANCE;
	
	int value;
	
	public int getValue() {
		return value;
	}
	
	public int setValue(int value) {
		return this.value = value;
	}
	
}



