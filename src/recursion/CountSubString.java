package recursion;

public class CountSubString {

	public static void main(String[] args) {
		
		String S="RazakImamShabanaRazakFaridaRazak";
		
		String S2="Razak";
		
		System.out.println(countSubString(S,S2));

	}

	private static int countSubString(String big, String sub) {
		
		if(big.length()==0) return 0;
		
		if(big.startsWith(sub))
			return 1+countSubString(big.substring(sub.length(), big.length()), sub);
		
		else return countSubString(big.substring(1),sub);
	}

}
