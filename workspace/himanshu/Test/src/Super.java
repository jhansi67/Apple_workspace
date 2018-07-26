
 class Super1 {
	
	
	

}

 class child extends Super1{}
 
 public class Super{
	 public static void main(String args[])
	 {
		 Super1 X=new Super1();
		 child Y;
		 
		 Y=(child)X;
	 }
 }