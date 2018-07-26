import java.util.Arrays;

public class ReverseArrayWithOutLoop {
	public static int i;
	public static void main(String vargs[])
	{
		int[] inp={10,11,12,13};
		Integer[] inp2={10,11,12,13,14};
		//Integer[] inp1={new Integer(10),Integer.getInteger("11"),Integer.valueOf("12"),new Integer(13)} ; //new Integer[10];
		//System.out.println(Arrays.binarySearch(inp, 11));
		inp2=new ReverseArrayWithOutLoop().swapElements(inp2, 0, inp2.length-1);
		for(int k : inp2)
			System.out.println(k);
		System.out.println(i);
	}
	
	
	public  Integer[] swapElements(Integer[] a,int startIndex, int endIndex)
	{
		if(startIndex < endIndex )
		{
		int temp=a[startIndex];
		a[startIndex]=a[endIndex];
		a[endIndex]=temp;
		i++;
		//swapElements(a, ++startIndex, --endIndex);
		swapElements(a, startIndex++, endIndex--);
		
		}
		
		return a;
	}

}

