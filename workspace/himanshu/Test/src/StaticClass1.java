
public class StaticClass1 {
	
	static int k=0;

	public StaticClass1() {
		// TODO Auto-generated constructor stub
		k++;
		System.out.println("StaticClass1 : "+k);
	}
	
	public int getValue()
	{
		static int j=0;
		return j++;
	}
	public static void main(String args[])
	{
		
		StaticClass1 s1=new StaticClass1();
		StaticClass1 s2=new StaticClass1();
		System.out.println("j  :  "+s1.getValue());
		System.out.println("j  :  "+s2.getValue());
		
		System.out.println("j  :  "+s1.getValue());
		System.out.println("j  :  "+s1.getValue());
	}

}

