package com.kurshit.DesignPatterns.Singleton;

public class DoubleCheckLazyInitialization {

	private static DoubleCheckLazyInitialization INSTANCE;

	private DoubleCheckLazyInitialization() { //private constructor is must

	}



	public static DoubleCheckLazyInitialization getInstance() {

		if(INSTANCE == null) {
			synchronized (DoubleCheckLazyInitialization.class) {
				if(INSTANCE == null) {
					return INSTANCE = new DoubleCheckLazyInitialization();
				}
			}

		}
		
		return INSTANCE;
	}

	
	public static void main(String[] args) {
		
		DoubleCheckLazyInitialization instance1 = DoubleCheckLazyInitialization.getInstance();
		System.out.println(instance1);
	}

}


