
public class Test5 implements Runnable {

	private int x;
	private int y;
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		for( ; ;)
		{
			x++;
			y++;
			
			System.out.println("x  "+x+ "  Y  "+y);
			
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test5 test=new Test5();
		(new Thread(test)).start();
		(new Thread(test)).start();
		
		
		
	}

}
