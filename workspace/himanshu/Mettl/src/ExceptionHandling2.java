
public class ExceptionHandling2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(parse("invalid"));
	}
	
	public static float parse(String val)
	{
		float f;
		try{
			f=Float.parseFloat(val);
			return f;
		}
		catch(Exception e)
		{
			f=1;
			System.out.println("Parser Exception");
		}
		finally
		{
			return f;
		}
	}

}
