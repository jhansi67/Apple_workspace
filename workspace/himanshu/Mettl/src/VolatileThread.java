
public class VolatileThread extends Thread {
	volatile int  count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VolatileThread vi=new VolatileThread();
		Thread t1=new Thread(vi,"t1");
		t1.start();
		Thread t2=new Thread(vi,"t2");
		t2.start();
		

	}

	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=0;count<5;i++)
		System.out.println(Thread.currentThread().getName()+" test   "+(++count));
	}
	
   

}
