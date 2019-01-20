package sorting;
import java.util.Scanner;
import java.util.stream.Stream;

public class SelectionSort {

	public static void main(String[] args) {
Scanner scanner=new Scanner(System.in);
		
		String in=scanner.nextLine();
		scanner.close();
		
		int[] a=Stream.of(in.split(" ")).mapToInt(Integer::valueOf).toArray();
		int[] b=a.clone();
		
		selectionSort(a);
		Stream.iterate(0, i->i+1).limit(a.length).forEach(i->System.out.print(a[i]+" "));
System.out.println();


		insertionSort(b);
		Stream.iterate(0, i->i+1).limit(a.length).forEach(i->System.out.print(a[i]+" "));

	}

	private static void insertionSort(int[] a) {
		
		for (int i = 0; i < a.length-1; i++) {
			int j=i+1;
			while(j-1 >=0 && a[j]<a[j-1])
				{
				int temp=a[j];
				a[j]=a[j-1];
				a[j-1]=temp;
				j--;
				}
			}
		}
		
	

	private static void selectionSort(int[] a) {
		
		int i=0;
		while(i<a.length)
		{
			int min=i;
			for (int j = i; j < a.length; j++) {
				if(a[j]<a[min])
					min=j;
			}
			
			//swap i with min
			int temp=a[i];
			a[i]=a[min];
			a[min]=temp;
			i++;
		}
		
	}

}
