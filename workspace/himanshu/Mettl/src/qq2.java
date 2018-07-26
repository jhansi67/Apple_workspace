class Hello{
int x;
Hello(int x){
	this.x=x;
}
public Object clone()
{
	Hello h=new Hello(x);
	return h;
}
public String toString()
{
	return ""+x;
}



}
public class qq2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello h=new Hello(56);
		System.out.println(h.clone());
		

	}

}
//56
