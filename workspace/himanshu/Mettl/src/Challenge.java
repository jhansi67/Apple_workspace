
public class Challenge {
  public static Integer cyclicString( String s ) {
	  
	  for (int i = 1;i<=s.length();i++) {
	        String part = s.substring(0,i);
	        System.out.print("--part--" +part);
	        boolean isRoot = true;
	        for (int j = 0;j<s.length();j++) {
	        	System.out.println("--" +s.charAt(j) +" "+ part.charAt(j % part.length()) +" "+(s.charAt(j) != part.charAt(j % part.length())));
	            if (s.charAt(j) != part.charAt(j % part.length())) {
	                isRoot = false;
	                break;
	            }
	        }
	        if (isRoot) {
	            return i;
	        }
	    }
	    return 0;
	    
     
   /* String line=str;
    String out="";
    
   
        ArrayList<String> subs = new ArrayList<>();
        String inp = line.trim();
        String t=inp + inp.substring(1,inp.length()-1);
        
        if(inp.length()>=3 && inp.length()<=15)
        {
          t=inp+inp.substring(0,inp.length());
        }
        if(t.length()<=15)
        {
          t=inp;
        }
        for (int i = 0; i < t.length(); i++) {
          
            
           String match = t.substring(0, t.length() - (i + 1));
            int mLength = match.length();
            if ( mLength <= t.length() / 2) {
                 if (t.substring(mLength, mLength * 2).equals(match)) {
                    out = match;
                    break;
                }
        }
        }
          
        out=inp;
       
        if(inp.length()>=2 && t.length()<=15)
        {
        for (int i = 0; i < t.length(); i++) {
            if (t.substring(0, t.length() - (i + 1)).equals(t.substring(i + 1,  t.length()))) {
               subs.add(t.substring(0, t.length() - (i + 1)));
            }
        }
        }
        subs.add(0, t);
        for (int j = subs.size() - 2; j >= 0; j--) {
            String match = subs.get(j);
            int mLength = match.length();
            if (j != 0 && mLength <= t.length() / 2) {
                 if (t.substring(mLength, mLength * 2).equals(match)) {
                    out = match;
                    break;
                }
            } else {
                out = match;
                break;
            }
        }
    
          return out.length();
    
    
*/        
    
    

 }
  
  public static void main(String args[])
  {
	  
	  //System.out.println("test");
	  System.out.println(cyclicString("abac"));
	  //System.out.println(cyclicString("bb"));
	  //System.out.println(cyclicString("abcdefghi"));
	 // System.out.println(cyclicString("aba"));
	 //System.out.println(cyclicString("acabaca"));
	 // 
	  
  }
  
  
  
}
