package cs3310;
import java.util.*;

public class MaxPath {

	public static int maxCost(int a[][], int n, int m)

	{
		int i,j;
		int maxValue[][] = new int[n+1][m+1];
		maxValue[0][0] = a[0][0];
		
		for(i=1;i<=n;i++) //initialize column 
		{
			maxValue[i][0]= maxValue[i-1][0] + a[i][0];
		}
		for(j=1;j<=m;j++) //initialize row
		{
			maxValue[0][j]= maxValue[0][j-1] + a[0][j];
		}
		
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=m;j++)
			{
				maxValue[i][j] = Math.max(Math.max(maxValue[i-1][j-1], maxValue[i-1][j-1]), maxValue[i][j-1] + a[i][j]);
			}
		}
		return maxValue[n][m];
	}
	
	public static void main(String[] args )
	{
		Random rng = new Random();
		
		//initialize random size 2d array
		//n column and m row random between 2 to 5
		int n = rng.nextInt(4)+2;
		int m = rng.nextInt(4)+2;
	
		int a[][] = new int[n][m];
		
		//fill 2d array with random values between -10 to 10
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				a[i][j] = (rng.nextInt(10)+1)*(rng.nextBoolean() ? -1 : 1); //max+min * either -1 or 1
			}
		}
		
		System.out.println("Num of Rows: " + n);
		System.out.println("Num of Columns: "+ m);
		
		System.out.println("Created Matrix: ");
		for(int i=0; i<n; i++) //print array
		{
			for(int j=0; j<m; j++)
			{
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		
		int result = maxCost(a,n-1,m-1);
		System.out.println("\nResult: "+result);
	}
}

