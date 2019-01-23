package com.kurshit.Raw;

public class B extends A {
	
	@Override
	public A getParent() {
		return new A();
	}

}
