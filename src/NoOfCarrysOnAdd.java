package test;

public class NoOfCarrysOnAdd {

	public static void main(String[] args) {

		
		System.out.println(numberOfCarryOperations(123, 456));//0
		System.out.println(numberOfCarryOperations(555, 555)); // 3
		System.out.println(numberOfCarryOperations(900, 11)); // 0
        System.out.println(numberOfCarryOperations(145, 55)); // 2
		System.out.println(numberOfCarryOperations(0, 0)); // 0
		System.out.println(numberOfCarryOperations(1, 99999)); // 5
		System.out.println(numberOfCarryOperations(999045, 1055)); // 5
		System.out.println(numberOfCarryOperations(101, 809)); // 1
		System.out.println(numberOfCarryOperations(189, 209));// 1
		
		System.out.println("recu");
		System.out.println(countDigitInNubmber(123, 456,0));//0
		System.out.println(countDigitInNubmber(555, 555,0)); // 3
		System.out.println(countDigitInNubmber(900, 11,0)); // 0
        System.out.println(countDigitInNubmber(145, 55,0)); // 2
		System.out.println(countDigitInNubmber(0, 0,0)); // 0
		System.out.println(countDigitInNubmber(1, 99999,0)); // 5
		System.out.println(countDigitInNubmber(999045, 1055,0)); // 5
		System.out.println(countDigitInNubmber(101, 809,0)); // 1
		System.out.println(countDigitInNubmber(189, 209,0));// 1
	}
	
	private static int countDigitInNubmber(int n1, int n2,int carry) {
		if(n1==0 && n2==0) return 0;
		
		int sum=n1%10+n2%10+carry;
		
		if(String.valueOf(sum).length()==2) return 1+countDigitInNubmber(n1/10,n2/10,1);
		
		return countDigitInNubmber(n1/10,n2/10,0); 
			
		
	}

	public static int numberOfCarryOperations(int a, int b) {
		int count = 0;
		int carry = 0;
		while (a > 0 && b > 0 || a==0 && b>0 || b==0&& a>0) {
		
			int r1 = a % 10;
			int r2 = b % 10;
			if (String.valueOf(r1 + r2 + carry).toCharArray().length == 2) {
				count++;
				carry=1;
			}else {
				carry=0;
			}

			a = a / 10;
			b = b / 10;
			
		}

		return count;
	}
}
