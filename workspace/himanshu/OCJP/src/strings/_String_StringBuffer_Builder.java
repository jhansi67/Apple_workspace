package strings;

public class _String_StringBuffer_Builder {

	public _String_StringBuffer_Builder() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str=new String("hello");
		StringBuffer strbuf=new StringBuffer("hello buf");
		StringBuilder strbud=new StringBuilder("hello bui");
		str.concat("test");
		strbuf.append("test");
		strbud.append("test");
		strbuf.appendCodePoint(6);
		int i='e';
		float k='h';
		double d='h';
		boolean b=true;
	
		System.out.println(str);
		System.out.println(strbuf);
		System.out.println(strbuf.codePointAt(1) +" "+ i); //unicode value of the character
		System.out.println(strbud);

	}

}
