package training_project;
import java.util.*;
import java.util.stream.*;
public class Test{		
 public static void main(String args[]){  
	 //sorting taking only first character into consideration
 ArrayList<String> list = new ArrayList<String>();
		list.add("yash");
		list.add("yello");
		list.add("yq");
		list.add("yau");
		list.add("there");
		list.add("cool");
		list.add("live");
		list.add("their");
		List<String> nw = list.stream().sorted((q1,q2)->q1.substring(0,1).compareTo(q2.substring(0,1))).collect(Collectors.toList());
System.out.println(nw);
 }
}