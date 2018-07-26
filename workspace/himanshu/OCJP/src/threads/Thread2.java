package threads;

public class Thread2 {

	
	public static void main (String[] args) {
	 new Thread2().go();
		 }
	 public void go() {
	Runnable r = new Runnable() {
		public void run() {
		 System.out.print("foo");
		 }
		 };
		 Thread t = new Thread(r);
		 t.start();
		 t.start();
		 }
}
