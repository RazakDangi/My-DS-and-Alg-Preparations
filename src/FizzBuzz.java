import java.util.stream.Stream;

public class FizzBuzz {

	public static void main(String[] args) {
		int N=1000;
		Stream.iterate(1, i->i+1)
		.limit(1000)
		.forEach(e->print(e));
	}

	private static void print(Integer e) {
		
		if(e%2==0 && e%3==0 && e%5==0)
			System.out.println("CodilityTestCoders");
		else if(e %2==0 && e%3==0)
			System.out.println("CodilityTest");
		else if(e %2==0 && e%5==0)
			System.out.println("CodilityCoders");
		else if(e %3==0 && e%5==0)
			System.out.println("TestCoders");
		else if(e%2==0)
			System.out.println("Codility");
		else if(e%3==0)
			System.out.println("Test");
		else if(e%5==0)
			System.out.println("Coders");
		else
			System.out.println(e);
	}
}
