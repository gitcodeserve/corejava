package com.test.thread;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		//3 threads are part of the barrier, ServiceOne, ServiceTwo and this main thread calling them.
		
		//Definition - CyclicBarrier is a synchronisation aid that allows a set of threads to wait for each other to reach a common barrier point. 
		//This means that all the threads reaching a specific point (called as barrier point) will have to wait for other threads to reach the same point. 
		//As soon as all the threads have reached the barrier point, all threads to are released to continue.
		
		//The barrier is called cyclic because it can be re-used after the waiting threads are released and that is where it is different than CountdownLatch. 
		//We can reuse CyclicBarrier by calling reset() method which resets the barrier to its initial state.
		
		final CyclicBarrier barrier = new CyclicBarrier(3);
		
		Thread serviceOneThread = new Thread(new ServiceOne(barrier));
		Thread serviceTwoThread = new Thread(new ServiceTwo(barrier));
		
		System.out.println("Starting both the services at"+new Date());
		
		serviceOneThread.start();
		serviceTwoThread.start();
		
		try {
			barrier.await();
			
			System.out.println("Main  - cyclicBarrier.getNumberWaiting() " + barrier.getNumberWaiting());
			System.out.println("Main - cyclicBarrier.getParties() " + barrier.getParties());
		} catch (InterruptedException e) {
			System.out.println("Main Thread interrupted!");
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			System.out.println("Main Thread interrupted!");
			e.printStackTrace();
		}
		System.out.println("Ending both the services at"+new Date());

	}

}

class ServiceOne implements Runnable {

	private final CyclicBarrier cyclicBarrier;

	public ServiceOne(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println("Starting service One...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Service One has finished its work... waiting for others...");
		try {
			cyclicBarrier.await();
			System.out.println("Service One - cyclicBarrier.getNumberWaiting() " + cyclicBarrier.getNumberWaiting());
			System.out.println("Service One - cyclicBarrier.getParties() " + cyclicBarrier.getParties());
		} catch (InterruptedException e) {
			System.out.println("Service one interrupted!");
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			System.out.println("Service one interrupted!");
			e.printStackTrace();
		}
		System.out.println("The wait is over, lets complete Service One!");

	}

}

class ServiceTwo implements Runnable {

	private final CyclicBarrier cyclicBarrier;

	public ServiceTwo(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println("Starting service Two....");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Service Two has finished its work.. waiting for others...");
		try {
			cyclicBarrier.await();
			System.out.println("Service two  - cyclicBarrier.getNumberWaiting() " + cyclicBarrier.getNumberWaiting());
			System.out.println("Service two  - cyclicBarrier.getParties() " + cyclicBarrier.getParties());
		} catch (InterruptedException e) {
			System.out.println("Service one interrupted!");
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			System.out.println("Service one interrupted!");
			e.printStackTrace();
		}
		System.out.println("The wait is over, lets complete Service two!");

	}

}
