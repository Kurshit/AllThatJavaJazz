package com.kurshit.pckg.test.azure;

import com.kurshit.pckg.test.TestScope;

public class ScopeApp {
	
	public final TestScope testScope;
	
	public ScopeApp(TestScope ts) {
		this.testScope = ts;
	}
	
	public void trial() {
		testScope.isAccesible();
	}
	
	

}
