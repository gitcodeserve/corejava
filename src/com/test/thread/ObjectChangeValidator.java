package com.test.thread;

public class ObjectChangeValidator extends Thread{

	private int number=10;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	public static void main(String ... args){
		ObjectChangeValidator validator1 = new ObjectChangeValidator();
		validator1.setNumber(20);
		System.out.println(validator1.getNumber());
		
		ObjectChangeValidator validator2 = new ObjectChangeValidator();
		validator2.setNumber(30);
		System.out.println(validator2.getNumber());
	}
}
