package lcm;

import java.math.BigInteger;
import java.util.Scanner;

public class LCM {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		long a = scanner.nextLong();
		long b = scanner.nextLong();

		scanner.close();

		System.out.println(lcm(a, b));
	}

	private static BigInteger lcm(long a, long b) {

		return BigInteger.valueOf((a * b) / gcd(a, b));
	}

	private static long gcd(long a, long b) {
		if (b == 0)
			return a;
		else {
			long r = a% b;
			return gcd(b, r);
		}
	}

}
