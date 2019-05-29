package com.kurshit.DesignPatterns.Singleton;

public class LazyInitialization {
	
	private  static LazyInitialization INSTANCE;
	
	private LazyInitialization() {  // private constructor is must
		
	}	
	
	
	public static synchronized LazyInitialization getInstance() throws InterruptedException {
	
		if(INSTANCE == null) {
			return INSTANCE = new LazyInitialization();
		}
		else 
			return INSTANCE;
	}
	
	

}
