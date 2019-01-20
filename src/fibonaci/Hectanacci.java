package fibonaci;

import java.math.BigInteger;
import java.util.Scanner;
/**
 * h(n)=h(n-1)+h(n-2)+h(n-3)+...+h(n-6)
 * series for combinations/no of way 6 face die can sum to n is resulting in Hectanacci series
 * @author rdangi
 *
 */
public class Hectanacci {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		scanner.close();
		
		System.out.println(hectanaci(n));
		
	}

	private static BigInteger hectanaci(int n) {
		if(n==0 || n==1) return BigInteger.valueOf(1);
		else
		{
			BigInteger[] mem=new BigInteger[n+1];
			mem[0]=BigInteger.valueOf(1);
			mem[1]=BigInteger.valueOf(1);
		for(int i=2;i<=n;i++) {	
		 if(i==2)
			mem[i]= mem[i-1].add(mem[i-2]);
		else if(i==3)
			mem[i]=mem[i-1].add(mem[i-2]).add(mem[i-3]);
		else if(i==4)
			mem[i]=mem[i-1].add(mem[i-2]).add(mem[i-3]).add(mem[i-4]);
		else if(i==5)
			mem[i]=mem[i-1].add(mem[i-2]).add(mem[i-3]).add(mem[i-4]).add(mem[i-5]);
			else {
			mem[i]= mem[i-1].add(mem[i-2]).add(mem[i-3]).add(mem[i-4]).add(mem[i-5])
					.add(mem[i-6]);
		}
		}
		return mem[n];
	}
		
	}

}
