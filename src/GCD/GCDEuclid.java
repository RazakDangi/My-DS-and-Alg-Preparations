package GCD;

import java.util.Scanner;

public class GCDEuclid {

	public static void main(String[] args) {
Scanner scanner=new Scanner(System.in);
		
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		
		scanner.close();
		
		System.out.println(gcd(a,b));
	}
	private static long gcd(int a, int b) {
		if(b==0)
			return a;
		else
		{
			int r=a%b;
			return gcd(b,r);
		}
	}		

}
