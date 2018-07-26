
public class StaticBlock {

	
	public StaticBlock() {
		// TODO Auto-generated constructor stub
	}
	
	  static{  
		  System.out.println("static block is invoked");  
		  System.exit(0);  
		  }  
		
	  
	  public StaticBlock getInstance()
	  {
		  
		  return this;
	  }
	  

}
