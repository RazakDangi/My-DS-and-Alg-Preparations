package dp.powerxn;

import java.math.BigDecimal;
import java.util.Scanner;

public class PowerXnRecursive {

	public static void main(String[] args) {

Scanner scanner=new Scanner(System.in);
		
		BigDecimal x=scanner.nextBigDecimal();
		BigDecimal n=scanner.nextBigDecimal();
		System.out.println(x.pow(n.intValue()).remainder(BigDecimal.TEN));
		scanner.close();
		//3^9
		//iterartive botom up approach
		//System.out.println(powerlinearRec(x,n).remainder(BigDecimal.TEN));//for n=100000 stack overflow
		//System.out.println(powerDividedRec(x,n).remainder(BigDecimal.TEN)); 
		System.out.println(powerMemo(x,n).remainder(BigDecimal.TEN)); 
		//System.out.println(power(x,n).remainder(BigDecimal.TEN)); 
	}
	private static BigDecimal powerlinearRec(BigDecimal x, BigDecimal n) {
		if(n==BigDecimal.ZERO) return BigDecimal.ONE;
		if(n==BigDecimal.ONE) return x;
		
		return x.multiply(powerlinearRec(x,n.subtract(BigDecimal.ONE)));
	}

	private static BigDecimal powerDividedRec(BigDecimal x, BigDecimal n) {
		if(n==BigDecimal.ZERO) return BigDecimal.ONE;
		if(n==BigDecimal.ONE) return x;
		
		if(n.remainder(BigDecimal.valueOf(2))==BigDecimal.ZERO)
			return powerDividedRec(x,n.divide(BigDecimal.valueOf(2))).multiply(powerDividedRec(x,n.divide(BigDecimal.valueOf(2))));
		
		return x.multiply(powerDividedRec(x,n.subtract(BigDecimal.ONE).divide(BigDecimal.valueOf(2))).multiply(powerDividedRec(x,n.subtract(BigDecimal.ONE).divide(BigDecimal.valueOf(2)))));
	}
 //cached value
	private static BigDecimal powerMemo(BigDecimal x, BigDecimal n) {
		if(n==BigDecimal.ZERO) return BigDecimal.ONE;
		if(n==BigDecimal.ONE) return x;
		BigDecimal cacheV=BigDecimal.ONE;
		if(n.remainder(BigDecimal.valueOf(2))==BigDecimal.ZERO) {
			 cacheV = powerMemo(x,n.divide(BigDecimal.valueOf(2)));
			return cacheV.multiply(cacheV);
		}
		
		 cacheV = powerMemo(x,n.subtract(BigDecimal.ONE).divide(BigDecimal.valueOf(2)));
		return x.multiply(cacheV.multiply(cacheV));
	}
	

}
