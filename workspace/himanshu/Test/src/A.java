
 class SA {
	public SA()
	{
		System.out.println("SA Cons");
	}
	public void getData()
	{
		System.out.println("Super");
	}
	public void getData1()
	{
		System.out.println("Super1");
	}
	public void getData3()
	{
		
	}

}

 class SB extends SA
{
	 public SB()
	 {
		 //super();
		System.out.println("SB Cons");
	 }
	
	public void getData()
	{
		//super();
		super.getData1();
		System.out.println("SB child");
	}
	
	public void getData4()
	{
		
		System.out.println("SB Data4 ");
	}
	
	
}
 
 class SC extends SB
 {
 	 public SC()
 	 {
 		 //super();
 		System.out.println("SC Cons");
 	 }
 	
 	public void getData()
 	{
 		//super();
 		super.getData();
 		System.out.println("SC child");
 		getData2();
 	}
 	public void getData2()
 	{
 		System.out.println("SC Data");
 		
 	}
 	
 	
 }

public class A 
{
	public static void main(String args[])
	{
		SA sa= new SB();
		System.out.println(sa instanceof SA);
		System.out.println(sa instanceof SB);
		SB sb=(SB)sa;
		System.out.println(sb instanceof SA);
		System.out.println(sb instanceof SB);
		//sa.getData();
		//SB sb=new SB();
		//sb.getData();
		
		//SA sa1=new SA();
				//sa1.getData();
				
		SC sa2=new SC();
		sa2.getData();
		
		
		
	}
}