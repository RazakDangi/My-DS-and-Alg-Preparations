package GCD;

import java.util.Scanner;

public class GCDRec {
	
public static void main(String args[]) {
		
		Scanner scanner=new Scanner(System.in);
		
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		
		scanner.close();
		
		System.out.println(gcd(a,b));
	}

private static int gcd(int a, int b) {
int gcd=0;
	for(int i=1;i<a+b;i++) {
		if(a%i==0 && b%i==0)
		gcd=i;
	
}return gcd;
	
}
}