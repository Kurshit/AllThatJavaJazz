package com.kurshit.ObjectPoolingExample;

public interface ObjectFactory {

	/**
	 * Returns a new instance of an object type T.
	 * 
	 * @return T an new instance of the object type T
	 */
	public abstract Object createNew();
}