import java.util.TreeSet;

public class TreeSize {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<String> st=new TreeSet<>();
		
		st.add("a");
		st.add("b");
		st.add("a");
		
		System.out.println(st.size());
		
		String str="Mahesh";
		String str1="MaheshKumar";
		System.out.println(str1.compareTo(str));
		
		new TreeSize().getString();;
		
		

	}
	String str3;
	String str4;
	
	public void getString()
	{
		
		//String str3;
		//String str4;
		
		String sty5=str3+str4;
		System.out.println(sty5);
		
	}

}
