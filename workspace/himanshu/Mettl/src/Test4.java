
public class Test4  extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         (new Test4()).start();
         (new Test4()).start();
         (new Test4()).start();
         (new Test4()).start();
         (new Test4()).start();
         (new Test4()).start();
	}
	
	public void run() {
		System.out.println("start");
	   yield();
		
	    System.out.println("end");
	}
	
	

}
