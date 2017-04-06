package com.test.thread;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	
	public static void main(String [] arg) throws InterruptedException{
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(1024);
		
		Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
        
        BlockingQueue<String> newQueue = new ArrayBlockingQueue(5);
        newQueue.add("xyz");
        newQueue.add("pqr");
        newQueue.add("abc");
        
        System.out.println(newQueue.remove());
        System.out.println(newQueue.remove());
        System.out.println(newQueue.remove());
        
       /* Stack<String> newStack = new Stack();
        newStack.add("xyz");
        newStack.add("pqr");
        newStack.add("abc");
        
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());
        System.out.println(newStack.pop());*/
        
	}
}


class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
