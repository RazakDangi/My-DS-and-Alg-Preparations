package fibonaci;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.ScrollPaneConstants;

public class RecursiveFibonaci {
	
	public static void main(String args[]) {
		
		Scanner scanner=new Scanner(System.in);
		//Iterator creates series of elements {0,1},{1,1},{1,2},{2,3},{3,5} 
	/*	Stream.iterate(new int[] {0,1}, a->new int[] {a[1],a[0]+a[1]})
		.limit(40)//limits series to 10 times 
		.map(e->e[0])//map array of two elments to array of one element which is first element
		.forEach(e->System.out.print("    "+e));
		*/
		System.out.println();
		Stream.iterate(new int[] {0,1}, a->new int[] {a[1],a[0]+a[1]})
		.limit(40)//limits series to 10 times 
		.map(e->new int[]{e[0]%2})
		.map(e->e[0])//map array of two elments to array of one element which is first element
		.forEach(e->System.out.print(" "+e));
		
		System.out.println();
		Stream.iterate(new int[] {0,1}, a->new int[] {a[1],a[0]+a[1]})
		.limit(40)//limits series to 10 times 
		.map(e->new int[]{e[0]%3})
		.map(e->e[0])//map array of two elments to array of one element which is first element
		.forEach(e->System.out.print(" "+e));
		
		System.out.println();
		Stream.iterate(new long[] {0,1}, a->new long[] {a[1],a[0]+a[1]})
		.limit(70)//limits series to 10 times 
		.map(e->new long[]{e[0]%10})
		.map(e->e[0])//map array of two elments to array of one element which is first element
		.forEach(e->System.out.print(" "+e));
		System.out.println();
		Stream.iterate(new long[] {0,1}, a->new long[] {a[1]%10,(a[0]+a[1])%10})
		.limit(70)//limits series to 10 times 
		.map(e->e[0])//map array of two elments to array of one element which is first element
		.forEach(e->System.out.print(" "+e));
		
		/*Stream.iterate(new BigDecimal[] {BigDecimal.ZERO,BigDecimal.ONE},
				f->new BigDecimal[] {f[1],f[0].add(f[1])})
		.limit(10)
		.map(e->e[0])
		.forEach(System.out::print);*/
		
		int n=scanner.nextInt();
	/*	ZonedDateTime nowRec = ZonedDateTime.now();
		System.out.println(fibo(n));
		System.out.println("REC "+nowRec.until(ZonedDateTime.now(), ChronoUnit.MILLIS)+" miliseconds");*/
		
		ZonedDateTime nowDP = ZonedDateTime.now();
		System.out.println(fiboITDP(n));
		System.out.println("DP " +nowDP.until(ZonedDateTime.now(), ChronoUnit.MILLIS)+" miliseconds");
	}

	private static long fibo(int n) {
		if(n<2)return n;
		else
			return fibo(n-1)+fibo(n-2);
		
	}
	private static long fiboITDP(int n) {
		if(n<2)return n;
		else {
			long op[]=new long[n+1];
			op[0]=0;
			op[1]=1;
			for(int i=2;i<=n;i++)
			{
				op[i]=op[i-1]+op[i-2];
			}
			return op[n];
		}
			
		
	}
	
	

}
