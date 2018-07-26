

public class qq21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(method());
	}
	 
	static int method()
	{
		System.out.println("----------");
		try{
			throw new ClassNotFoundException();
		}
		catch(Exception e)
		{
           System.out.println(e);
           return 1;
			//throw new NullPointerException();
		}
		/*finally {
			return 0;     // 0
		}*/
	}

}


//Null Pointer Exception