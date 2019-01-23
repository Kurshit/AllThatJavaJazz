package com.kurshit.ObjectPoolingExample;

public interface Pool
{

	/*
	 * @return one of the pooled objects.
	 */
	Object get();

	/*
	 * @param object T to be return back to pool
	 */
	void release(Object object);

	/**
	 * Shuts down the pool. Should release all resources.
	 */
	void shutdown();
}
