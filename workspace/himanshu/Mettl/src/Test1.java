
public class Test1 {

	public Test1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte a=65,b;
		int i= a<<1;
		//b= (byte) a<<2;
		System.out.println("a   : "+a+"   i  : "+i);
		
		 i= a<<2;
		//b= (byte) a<<2;
		System.out.println("a   : "+a+"   i  : "+i);
		
		 i= a<<3;
		//b= (byte) a<<2;
		System.out.println("a   : "+a+"   i  : "+i);
		
		 i= a>>1;
		//b= (byte) a<<2;
		System.out.println("a   : "+a+"   i  : "+i);
		
		i= a>>2;
			//b= (byte) a<<2;
			System.out.println("a   : "+a+"   i  : "+i);
			
			
			i= a>>3;
		//b= (byte) a<<2;
		System.out.println("a   : "+a+"   i  : "+i);
		
		
		
		i= a>>>1;
		//b= (byte) a<<2;
		System.out.println("a   : "+a+"   i  : "+i);
		
		
		i= a>>>2;
		//b= (byte) a<<2;
		System.out.println("a   : "+a+"   i  : "+i);

	}

}
