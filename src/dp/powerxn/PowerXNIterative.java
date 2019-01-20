package dp.powerxn;

import java.util.Scanner;

public class PowerXNIterative {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
	int x=scanner.nextInt();
	
	int n=scanner.nextInt();
	
	//3^9
	
	//Iterative bottom up approach
	System.out.println(power(x,n)); 

	}

	private static int power(int x, int n) {
		
		if(n==0) return x;
		if(n==1) return  1;
		int result=1;//table filling value 
		while(n>0) {
			if((n&1)==1)//odd 
				result=result*x;
			n=n>>1;//n=n/2
			x=x*x;
		}
		return result;
	}

}
