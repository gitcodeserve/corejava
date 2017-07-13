package com.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletebleFutureEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("Calling on synchronized method getPrice and wait for 2 sec.");
		getSyncPrice();
		System.out.println("Move on to next task...");
		
		System.out.println("Starting a new API call in asyn mode.....  (In seperate thread .... )");
		CompletableFuture<Integer> futureRes = getAsyncPrice();
		
		System.out.println("Continue with other work .....");
		System.out.println("Main thread is sleeping for 7 seconds " + Thread.currentThread().getName());
		Thread.sleep(7000);
		
		try {
			System.out.println("API calls return back after 5 seconds ");
			System.out.println("Returned value from the future object  " + futureRes.get());
			System.out.println("API call is completed");
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Continue with other work ..... 2");
		System.out.println("Main call completed .... ");
		
	}
	
	
	public static int getSyncPrice(){
		
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1000;
	}
	
	
	public static CompletableFuture<Integer> getAsyncPrice() {
		CompletableFuture<Integer> future = new CompletableFuture<>();
		//Start a new thread to assign future value ...
		new Thread(() ->{
		try {
			for(int i =0; i<5; i++){
				System.out.println("Child thread sleeping for " + (i+1) + " second " + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
			
			future.complete(5000);
			//throw new RuntimeException("Hello exception ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			future.completeExceptionally(e);
			e.printStackTrace();
		}}).start();;
		return future;
	}

}


