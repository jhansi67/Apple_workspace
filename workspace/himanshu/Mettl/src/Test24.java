import java.lang.invoke.SwitchPoint;

public class Test24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		X x=new X();
		x.show(5);
		System.out.println(x.x);
		
		
		char c='A';
		
		switch(65){
		case 'A':
			System.out.println("c");
			break;
		//case 65:
		//	System.out.println("c");
		case 'C':
			System.out.println("c");
		default:
			System.out.println("done");
		
		}
		
		long lo=2l;
		switch (lo) {
		case 1:
			System.out.println("l");
			break;
		case 2:
			System.out.println("2");
			break;


		default:
			break;
		}


	}
	
	
}

class X{
	
	int x=12;
	public void show(int x)
	{
		x+=x;
		System.out.println(x);
	}
	
}
