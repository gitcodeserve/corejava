package com.test.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] args) {
		// intialising count down latch by 2, as it will wait for 2 threads to
		// finish execution
		final CountDownLatch latch = new CountDownLatch(2);

		// making two threads for 2 services
		Thread serviceOneThread = new Thread(new Service1(latch));
		Thread serviceTwoThread = new Thread(new Service2(latch));

		serviceOneThread.start();
		serviceTwoThread.start();

		// latch waits till the count becomes 0
		// this way we can make sure that the execution of main thread only
		// finishes ones 2 services have executed
		try {
			System.out.println("Main thread waiting for 8 second to decrease the latch to 0");
			latch.await();
			System.out.println("Starting main Thread!!!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Service1 implements Runnable {

	private final CountDownLatch latch;

	public Service1(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Started service One --");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// reduce count of Count Down Latch by 1.
		latch.countDown();
		System.out.println(" Service 1 Count down latch by 1 ");

	}

}

class Service2 implements Runnable {
	private final CountDownLatch latch;

	public Service2(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("started service Two");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
		System.out.println(" Service 2 Count down latch by 2 ");
	}

}