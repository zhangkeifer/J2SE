package com.somnus.random;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class RandomTest {
	
	@Test
	public void test1(){
		Random random = new Random(10);
		System.out.println(random.nextInt());
		
		random = new Random(10);  
		System.out.println(random.nextInt());
		
		random = new Random(10);  
		System.out.println(random.nextInt());
	}
	
	/**
	 * -1157793070
	 * 1913984760
     * 1107254586
	 */
	@Test
	public void test2(){
		Random random = new Random(10); 
		for (int i = 0; i < 3; i++){
			System.out.println(random.nextInt());
		}
	}
	
	
	private static Random random = new Random(10);     
               
    public static void main(String[] args) {
        ExecutorService taskPool = Executors.newCachedThreadPool();
        
        final CountDownLatch latch = new CountDownLatch(2);
    	
        for(int i = 0; i < 100; i++){
        	final int taskID = i;
        	taskPool.submit(new Runnable(){

    			@Override
    			public void run() {
    				try {
						latch.countDown();
						latch.await();
						
						StopWatch sw = new StopWatch();
						sw.start();
						
						for(int j = 0; j < 10000000; j++){
							random.nextInt(10);
						}
						sw.stop();
						
						System.out.println(Thread.currentThread().getName() + " >>>> " + taskID + " >>>> " + sw.getTime());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
            	
            });
        }
    	
        taskPool.shutdown();
    }

}
