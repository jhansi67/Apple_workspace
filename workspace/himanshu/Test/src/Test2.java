
public class Test2{
	
	public static void main(String args[])
	{
		int j=5,i;
		
		for( i=0;i<j;i++)
		{
			if(i<j-- && --j>0)
			{
				System.out.println("i"+ i+" j  : "+j);
				System.out.println(i*j);
			}
		}
		System.out.println("i  "+i);
		
	}

}
