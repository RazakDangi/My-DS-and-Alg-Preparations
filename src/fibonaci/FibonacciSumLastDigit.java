package fibonaci;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.Stream;

public class FibonacciSumLastDigit {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
	        BigInteger n = scanner.nextBigInteger();
	        if(n.compareTo(BigInteger.ONE) !=1)
	        	  System.out.println(n.mod(BigInteger.TEN));
	        else {
	        	long p=getPeriodicSize(10);
	        long s = getFibonacciSumNaive(n.add(BigInteger.valueOf(2)).mod(BigInteger.valueOf(p)).longValue());
	        System.out.println(s);}
	        
		

	}

	private static long getFibonacciSumNaive(long n) {
		// TODO Auto-generated method stub
		return (fiboNModm(n,10)-1+10)%10;
	}

	private static long fiboNModm(long n, long m) {
		if(n<2) return n;
		long f1=0;
		long f2=1;
		long f3=0;
		for(int i=2;i<=n;i++) {
			f3=(f1+f2)%m;
			f1=f2;
			f2=f3;
		}
		return f3;
		
	}

	private static long getPeriodicSize(long m) {
		long f1=1;
		long f2=1;
		long f3=0;
		long count=1;
		while(!(f2==1 && f1==0))
		{
			f3=(f2+f1)%m;
			f1=f2;
			f2=f3;
			count++;
		}
		return count;
	}

}
