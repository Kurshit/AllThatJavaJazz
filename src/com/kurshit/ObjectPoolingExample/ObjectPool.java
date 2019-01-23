package com.kurshit.ObjectPoolingExample;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
 
public abstract class ObjectPool implements ObjectFactory, Pool {
    
   private int size;
    
   private boolean shutdown;
    
   private BlockingQueue objects;
    
   public ObjectPool(int size) {
      this.size = size;
      shutdown = false;
      init();
   }
    
   /*
    * initiate the pool with fix size
    */
   private void init() {
      objects = new LinkedBlockingQueue();
      for (int i = 0; i < size; i++) {
         objects.add(createNew());
      }
   }
    
   @Override
   public Object get() {
      if (!shutdown) {
         Object t = null;
                     
         try {
            t = objects.take();
         }
         catch (Exception e) {
            e.printStackTrace();
         }
            
         return t;
      }
        
      throw new IllegalStateException("Object pool is already shutdown.");
   }
    
   @Override
   public void release(Object t) {
      try {
         objects.offer(t);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
    
   @Override
   public void shutdown() {
      objects.clear();
      shutdown = true;
   }
    
   public int size() {
      return objects.size();
   }
    
}
