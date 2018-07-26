
public class ChildClass implements TestInheritance{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestInheritance ti=new ChildClass();
		ti.getData2();
		ti.getData1();
	}

	@Override
	public void getData2() {
		
		System.out.println("Child Class");
		
	}
	
	//@Override
	public static void getData1()
	{
		System.out.println("child Class");
		
	}
	
	

}
