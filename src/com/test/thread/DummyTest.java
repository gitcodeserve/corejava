package com.test.thread;

class Dummy implements Runnable{
	
	public Dummy() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void  test(){
		System.out.println("Parent test .... ");
		System.out.println("--- " + Thread.currentThread());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("parent run ... ");
	}

}

class DummyChild extends Dummy 
{
	public DummyChild() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("child constructor ... ");
		
	}
	
	
	
	@Override
	public synchronized void test() {
		// TODO Auto-generated method stub
		System.out.println("child test ....");
		System.out.println("--- child " + Thread.currentThread());
		super.test();
	}
	
	@Override
	public void run() {
		test();
		
	}
}

public class DummyTest{
	
	public static void main(String ...strings ){
		
		Thread t1 = new Thread(new Dummy(), "PARENT THREAD");
		Thread t2 = new Thread(new DummyChild(), "CHILD THREAD");
		
		t1.start();
		t2.start();
		
	}
	
}
