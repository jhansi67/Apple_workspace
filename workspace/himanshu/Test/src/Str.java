
public class Str {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text=new String("text");
		//text=text.intern();
		String text1="text";
		String text2="text";
		System.out.println(Integer.toHexString(text.hashCode()));
		System.out.println(Integer.toHexString(text1.hashCode()));
		System.out.println(Integer.toHexString(text2.hashCode()));
		
		if(text == text1)
		{
			System.out.println("true");
		}
		
		if(text2.equals(text1))
		{
			System.out.println("#true");
		}
	}

}

