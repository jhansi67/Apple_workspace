
public class q27 {
	
	public static void main(String vargs[])
	{
		int i=2;
		int x[]={10,20,50,45,95,14};
		//i=i++; //i=2
		//i++; //i=3
		x[i]=x[i=i++];  //i=2
		System.out.println("---"+x[i=i++]);
		//x[i]=x[i=++i]; //i=3
		//x[i]=x[i++];
		System.out.println(i+"   "+x[i]);
		
	
	}

}

//i=i++ output 50
//i=++i or i++ output 45