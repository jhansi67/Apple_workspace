
public class Test3 {
	TestThis testThis;

public Test3()
{
	 testThis=new TestThis(this);
}

class TestThis{
	Test3 test1;
	public TestThis(Test3 aThis)
	{
		test1=aThis;
	}
}

public static void main(String[] args)
{
	Test3 test2=new Test3();
	test2=null;
	
	boolean b1=false;
	boolean b2=false;
	if(b2 != b1 != !b2)
	{
		System.out.println("true");
		
	}
	else
	{
		System.out.println("false");
	}
	
	String str1="one";
	String str2="two";
	System.out.println("--"+str1.equals(str2=str1)); //true
	System.out.println("--"+str1.equals(str1=str2)); //false
}
}
