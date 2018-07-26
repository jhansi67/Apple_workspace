
public class ThreadDemo<anygen> {
	
	anygen filed;

	public ThreadDemo(anygen filed) {
		// TODO Auto-generated constructor stub
		this.filed=filed;
	}
	
	public ThreadDemo() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void main(String args[])
	{
		
		ThreadDemo<int> arr=new ThreadDemo<int>();
		
		/*arr[0]=new ThreadDemo("Str");
		arr[1]=new ThreadDemo(1);
		arr[2]=(ThreadDemo<String>)new ThreadDemo(1);*/
		
	}
	
	public void parse(String str)
	{
		
		try{
	  float f=Float.parseFloat(str);
		}catch(NumberFormatException ne)  
		{
			//f=0;
		}
		finally{
		//	System.out.println(f);
		}
		
	}

}

interface f1
{
	public void show();
}
interface f2
{
	public void show();
}

class f3 implements f1,f2
{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
}

	
