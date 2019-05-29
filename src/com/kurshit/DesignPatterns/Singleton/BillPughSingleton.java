package com.kurshit.DesignPatterns.Singleton;

public class BillPughSingleton {
			
	private BillPughSingleton() {
		
	}
	
	private static class SingltonHelper {
		
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return SingltonHelper.INSTANCE;
	}
	
	
	
}
