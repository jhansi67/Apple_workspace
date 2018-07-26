package training_project;
//simple lamda expressions
public class lambdatest {
public static void main(String args[])
{
	la obj1 = (a,b)-> {return a+b;};
	lau obj2 =(q)-> System.out.println("hello"+q);

	obj2.mess("high");
	System.out.println(obj1.add(4,3));
}
}
interface la{
	public int add(int a, int b);
}
interface lau{
	public void mess(String m);
}