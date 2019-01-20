package fibonaci;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonaciMulti {
 
	    /* function that returns nth Fibonacci number */
		static BigInteger one=BigInteger.valueOf(1);
		static BigInteger zero=BigInteger.valueOf(0);
	    static BigInteger M[][] = new BigInteger[][]{{one,one},{one,zero}};  
	    static BigInteger fib(int n) 
	    { 
	    BigInteger F[][] = new BigInteger[][]{{one,one},{one,zero}}; 
	    if (n == 0) 
	        return BigInteger.valueOf(0); 
	    power(F, n-1); 
	       
	    return F[0][0]; 
	    } 
	       
	    static void multiply(BigInteger F[][], BigInteger M[][]) 
	    { 
	    BigInteger x =  F[0][0].multiply(M[0][0]).add(F[0][1].multiply(M[1][0])); 
	    BigInteger y =  F[0][0].multiply(M[0][1]).add(F[0][1].multiply(M[1][1]));
	    BigInteger z =  F[1][0].multiply(M[0][0]).add(F[1][1].multiply(M[1][0]));
	    BigInteger w =  F[1][0].multiply(M[0][1]).add(F[1][1].multiply(M[1][1]));
	      
	    F[0][0] = x; 
	    F[0][1] = y; 
	    F[1][0] = z; 
	    F[1][1] = w; 
	    } 
	       
	    /* Optimized version of power() in method 4 */
	    static void power(BigInteger F[][], int n) 
	    { 
	    if( n == 0 || n == 1) 
	      return; 
	   	       
	    power(F, n/2); 
	    multiply(F, F); 
	       
	    if (n%2 != 0) 
	       multiply(F, M); 
	    } 
	      
	    /* Driver program to test above function */ 
	    public static void main (String args[]) 
	    { 
	    	Scanner scanner=new Scanner(System.in);
			
			int n=scanner.nextInt();
			
			scanner.close();
			try {
	     System.out.println(fib(n).mod(BigInteger.valueOf(10)).intValue()); }
catch (Exception e) {
	System.out.println(e);
}	
}
}
