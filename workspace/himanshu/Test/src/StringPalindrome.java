

public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//args[0]="teet1Test";
		for(int i=0;i<args[0].length();i++)
		{
			for(int j=args[0].length();j>i;j--)
			{
				if(isPalindrome(args[0].substring(i,j)))
				{
					System.out.println(args[0].substring(i,j));
				}
			}
		}

	}
	
	private static boolean isPalindrome(String inp)
	{
		boolean res=true;
		//System.out.println(inp);
		if(inp.length()>2)
		{
		for(int start=0,end=inp.length()-1;start<inp.length()/2;start++,end--)
		{
			//System.out.println("start : "+ start + " End : "+end + " ");
			if(inp.charAt(start)!=inp.charAt(end))
			{
				res=false;
				break;
			}
				
		}
		}
		else
			res=false;
		
		return res;
	}

}

