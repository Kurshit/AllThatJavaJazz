package com.kurshit.MyThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPool {
	 
    private BlockingQueue<Runnable> taskQueue;
   
    /*
     * Once pool shutDown will be initiated, poolShutDownInitiated will become true.
     */
    private boolean poolShutDownInitiated = false;
 
    /* Constructor of ThreadPool
     * nThreads= is a number of threads that exist in ThreadPool.
     * nThreads number of threads are created and started.  *
     */
    public MyThreadPool(int nThreads){
        taskQueue = new LinkedBlockingQueue<Runnable>(nThreads);
 
        //Create and start nThreads number of threads.
        for(int i=1; i<=nThreads; i++){
           ThreadPoolsThread threadPoolsThread=new ThreadPoolsThread(taskQueue,this);
         threadPoolsThread.setName("Thread-"+i);
         System.out.println("Thread-"+i +" created in ThreadPool.");
         threadPoolsThread.start();   //start thread
        }
       
    }
 
   
    /**
     * Execute the task, task must be of Runnable type.
     */
    public synchronized void  execute(Runnable task) throws Exception{
        if(this.poolShutDownInitiated)
           throw new Exception("ThreadPool has been shutDown, no further tasks can be added");
       
        /*
      * Add task in sharedQueue,
      * and notify all waiting threads that task is available.  
            */
        System.out.println("task has been added");
        this.taskQueue.put(task);
    }
 
 
    public boolean isPoolShutDownInitiated() {
           return poolShutDownInitiated;
    }
 
 
    /**
     * Initiates shutdown of ThreadPool, previously submitted tasks
     * are executed, but no new tasks will be accepted.
     */
    public synchronized void shutdown(){
       this.poolShutDownInitiated = true;
        System.out.println("ThreadPool SHUTDOWN initiated.");
    }
 
}
 
 
/**
 * These threads are created and started from constructor of ThreadPool class.
 */
class ThreadPoolsThread extends Thread {
 
    private BlockingQueue<Runnable> taskQueue;
    private MyThreadPool threadPool;
 
    public ThreadPoolsThread(BlockingQueue<Runnable> queue,
                  MyThreadPool threadPool){
        taskQueue = queue;
        this.threadPool=threadPool;
       
    }
 
    public void run() {
           try {
                  /*
                   * ThreadPool's threads will keep on running
                   * until ThreadPool is not shutDown (shutDown will interrupt thread) and
                   * taskQueue contains some unExecuted tasks.
                   */
                  while (true) 
                  {    
                        System.out.println(Thread.currentThread().getName()
                                      +" is READY to execute task.");
                        /*ThreadPool's thread will take() task from sharedQueue
                         * only if tasks are available else
                         * waits for tasks to become available.
                         */
                        Runnable runnable = taskQueue.take();
                        System.out.println(Thread.currentThread().getName()
                                      +" has taken task.");
                        //Now, execute task with current thread.
                        runnable.run();                
                        
                        System.out.println(Thread.currentThread().getName()
                                      +" has EXECUTED task.");
                        
                        /*
                         * 1) Check whether pool shutDown has been initiated or not,
                         * if pool shutDown has been initiated and
                         * 2) taskQueue does not contain any
                         *    unExecuted task (i.e. taskQueue's size is 0 )
                         * than  interrupt() the thread.
                         */
                        if(this.threadPool.isPoolShutDownInitiated()
                                      &&  this.taskQueue.size()==0){
                               this.interrupt();
                               /*
                                *  Interrupting basically sends a message to the thread
                                *  indicating it has been interrupted but it doesn't cause
                                *  a thread to stop immediately,
                                * 
                                *  if sleep is called, thread immediately throws
                                *  InterruptedException
                                */
                               Thread.sleep(1);  
                        }   
                  }
           } catch (Exception e) {
                  System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
           }
    }
}
 
 
/**
 * Task class which implements Runnable.
 */
class Task implements Runnable{  
    String name;
	Task(String name)
	{
		this.name = name;
	}
	@Override
    public void run() {
           try {
                  Thread.sleep(2000);
                  System.out.println(Thread.currentThread().getName()
                               +" is executing task  -- " +name);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
    }
};
 
/**
 * Test ThreadPool.
 */
public class ThreadPoolTest{
    public static void main(String[] args) throws Exception {
           MyThreadPool threadPool=new MyThreadPool(2); //create 2 threads in ThreadPool 
           Runnable task1=new Task("Kurshit");
           Runnable task2=new Task("Sumit");
           Runnable task3=new Task("Sakshi");
           Runnable task4=new Task("Shweta");
           threadPool.execute(task1);
           threadPool.execute(task2);
           threadPool.execute(task3);
           threadPool.execute(task4);
           
           threadPool.shutdown();
           
    }
    
}