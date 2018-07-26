package com.thread.examples;

public class TestWait extends Thread {
boolean value=true;
	public TestWait() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestWait tw=new TestWait();
	Thread t1=new Thread(tw);
	Thread t2=new Thread(tw);
		t1.start();
		t2.start();
		

	}
	
	public void run() {
		
		for(int i=0;i<10;i++){
			try{
			synchronized (this) {
				System.out.println(i+Thread.currentThread().getName());	
			    if(value)
			    {
			    value=false;
				wait();
				//sleep(1000);
				
			    }
			    else
			    {
			    	notify();
			    	value=true;
			    }
				
			}
			}
			catch(Exception e)
			{
				System.out.println("Exception "+e);
			}
		}
		System.out.println("done");
		
	}

}
