interface A{
	void test();
	//public void test();   // compile error
}

class B implements A{
	
	public void test(){   //line 8
		
	}
	
//public void test(){}
}



public class Testin2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//while using interfaces we cannot reduce the visbulity compile error
// for removing compiler error check line 9
 

//compile error at line 8 public access modifier required