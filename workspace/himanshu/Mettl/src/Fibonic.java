
public class Fibonic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		System.out.println(fibonacci1(5));
	}

	public static int fibonacci1(int index)
	{
		if(index==1 || index ==2)
		{
			return 1;
		}
		return fibonacci1(index-1)+fibonacci1(index-2);
		
	}
}
