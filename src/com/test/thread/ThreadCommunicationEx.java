package com.test.thread;

public class ThreadCommunicationEx {

	public static void main(String[] args) {
		Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter 1").start();
         
        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter 2").start();
         
        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
	}

}


class Message{
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Message(String msg) {
		this.message = msg;
	}
	
}


class Waiter implements Runnable{
	
	private Message msg;
	
	public Waiter(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		synchronized (msg) {
			System.out.println(currentThreadName + " waiting to get notified at time " + System.currentTimeMillis()/60);
			try {
				msg.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(currentThreadName+" waiter thread got notified at time:"+System.currentTimeMillis());
	            //process the message now
	         System.out.println(currentThreadName+" processed: "+msg.getMessage());
		}
		
	}
	
}

class Notifier implements Runnable{

	private Message msg;
	
	public Notifier(Message msg){
		this.msg = msg;
	}
	/**
	 * 
	 */
	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("started ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (msg) {
			System.out.println(currentThreadName + " Notifier work done .. ");
			msg.notify();
		}

		
	}
	
}
