package sorting;
import java.util.Scanner;
import java.util.stream.Stream;

public class BubuleSort {

	public static void main(String[] args) {
		
	Scanner scanner=new Scanner(System.in);
		
		String in=scanner.nextLine();
		scanner.close();
		
		int[] a=Stream.of(in.split(" ")).mapToInt(Integer::valueOf).toArray();
		
		bubbleSort(a);
		Stream.iterate(0, i->i+1).limit(a.length).forEach(i->System.out.print(a[i]+" "));
	}

	private static void bubbleSort(int[] a) {
		boolean swapped=true;
		while(swapped)
		{
			swapped=false;
			for (int i = 0; i < a.length-1; i++) {
				if (a[i]>a[i+1]) {
					int temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
					swapped=true;
				}
			}
		}
		
	}

}
