package training_project;
import java.util.*;
import java.util.stream.*;
public class Testinterface{		
 public static void main(String args[]){  
	 //sorting
 ArrayList<String> list = new ArrayList<String>();
		list.add("yash");
		list.add("hello");
		list.add("bye");
		list.add("you");
		list.add("there");
		list.add("cool");
		list.add("live");
		list.add("their");
		List<String> nw = list.stream().sorted().collect(Collectors.toList());
System.out.println(nw);
 }
}