package fibonaci;

import java.math.BigDecimal;
import java.util.Scanner;

public class PisanoPeriod {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		BigDecimal n=scanner.nextBigDecimal();
		long m=scanner.nextLong();
		long p=getPeriodicSize(m);
		
		System.out.println(fiboNModm(n.remainder(BigDecimal.valueOf(p)).longValue(),m));
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
