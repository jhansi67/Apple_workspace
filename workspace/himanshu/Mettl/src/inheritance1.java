
public class inheritance1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IA a=new IB();
		a.test();
		a.tes
		((IB)a).test1();
		Foo f= new Foo();
		
		Foo.Bar b=f.new Bar();

	}
	
	

}

class IA
{
	public void test()
	{
		System.out.println("Parent");
	}
	
}


class IB extends IA
{
	public void test()
	{
		System.out.println("Child");
	}
	public void test1()
	{
		System.out.println("Test1");
	}
	
}

class Foo{

	
	public class Bar{
		
	}
	
}
	
	



