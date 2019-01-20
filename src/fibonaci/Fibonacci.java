package fibonaci;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		long n = scanner.nextLong();

		scanner.close();
	
		System.out.println(fibo(n));

	}

	/**
	 * Iteration or Bottom up approach 
	 * @param n
	 * @return
	 */
	private static BigInteger fibo(long n) {
		if (n <= 1)
			return BigInteger.valueOf(n);
		else {

			BigInteger f1 = BigInteger.valueOf(0);
			BigInteger f2 = BigInteger.valueOf(1);
			BigInteger f3 = f1.add(f2);
			for (long i = 2; i < n + 1; i++) {
				f3 = f1.add(f2);
				f1 = f2;
				f2 = f3;
			}
			return f3;

		}
	}

}
