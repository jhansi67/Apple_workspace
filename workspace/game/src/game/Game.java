package game;

import java.util.Scanner;

public class Game {
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int x[][]={{0,0,0},{0,0,0},{0,0,0}};
		int value1=1;
		int value2=2;
		int a=0;
		int b=0;
		int currentvalue=value1;
		for(int i=0;i<9;i++)
		{
			System.out.println("enter the coordinates by  player"+currentvalue+":");
			a=s.nextInt();
			b=s.nextInt();
			if(a>=3&&b>=3)
				System.out.println("wrong entry");
			else{
			if(x[a][b]==0)
			{
				x[a][b]=currentvalue;
			}
			for(int c=0;c<3;c++)
			{
				System.out.print("|");
				for(int d=0;d<3;d++)
				{
					System.out.print(" "+x[c][d]+" |");
					
				}
				System.out.println();
				System.out.println("_____________");
			}
			if(a!=b)
			{
				if(x[a][0]==x[a][1]&&x[a][1]==x[a][2]&&x[a][0]!=0&&x[a][1]!=0&&x[a][2]!=0)
				{
					System.out.println("the player won is "+currentvalue);
					break;
				}
				if(x[0][b]==x[1][b]&&x[1][b]==x[2][b]&&x[0][b]!=0&&x[1][b]!=0&&x[2][b]!=0)
				{
					System.out.println("the player won is "+currentvalue);
					break;
				}
			}
			if(a==b||(a+b==2))
			{
				if(x[a][0]==x[a][1]&&x[a][1]==x[a][2]&&x[a][0]!=0&&x[a][1]!=0&&x[a][2]!=0)
				{
					System.out.println("the player won is "+currentvalue);
					break;
				}
				if(x[0][b]==x[1][b]&&x[1][b]==x[2][b]&&x[0][b]!=0&&x[1][b]!=0&&x[2][b]!=0)
				{
					System.out.println("the player won is "+currentvalue);
					break;
				}
				if(x[0][0]==x[1][1]&&x[1][1]==x[2][2]&&x[0][0]!=0&&x[1][1]!=0&&x[2][2]!=0)
				{
					System.out.println("the player won is "+currentvalue);
					break;
				}
				if(x[0][2]==x[1][1]&&x[1][1]==x[2][0]&&x[0][2]!=0&&x[1][1]!=0&&x[2][0]!=0)
				{
					System.out.println("the player won is "+currentvalue);
					break;
				}
				
			}
			}
			if(currentvalue==value1)
				currentvalue=value2;
			else 
					currentvalue=value1;
			if(i==8)
			{
				System.out.println("the game is draw");
			}
		}
		
	}

}

