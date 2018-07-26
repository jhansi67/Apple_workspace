
public class TestInh1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	interface SC{
		
	}
	
	private class SD{}
	
	abstract class SE{}
	
	public static class SR{}

}

abstract class SF
{
	
	public void getData()
	{
		
	}
	  abstract  void getDat1();
}

class SG extends SF
{

	@Override
	public void getData() {
		// TODO Auto-generated method stub
		super.getData();
	}

	@Override
	public void getDat1() {
		// TODO Auto-generated method stub
		
	}
	
}

class SJ extends SH
{
	
}
