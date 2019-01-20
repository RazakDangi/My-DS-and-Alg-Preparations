package recursion;

public class CountADigitInNumber {

	public static void main(String[] args) {
		
		int n=1237393;
		
		System.out.println(countDigitInNubmber(n,3));
	}

	private static int countDigitInNubmber(int n, int i) {
		if(n==0) return 0;
		
		if(n%10==i) return 1+countDigitInNubmber(n/10,i);
		
		return countDigitInNubmber(n/10,i);
			
		
	}

}
