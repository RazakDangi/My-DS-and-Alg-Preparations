package sorting;
import java.util.Scanner;
import java.util.stream.Stream;

public class QuickSort {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String in = scanner.nextLine();
		scanner.close();
		int[] input = Stream.of(in.split(" ")).mapToInt(Integer::valueOf).toArray();

		Stream.iterate(0, i -> i + 1).limit(input.length).forEach(i -> System.out.print(input[i] + " "));

		System.out.println();
		quickSort(input, 0, input.length - 1);

		Stream.iterate(0, i -> i + 1).limit(input.length).forEach(i -> System.out.print(input[i] + " "));
	}

	private static int[] quickSort(int[] input, int low, int high) {
		if (input.length > 1) {

			int index = getPivot(input, low, high);

			if (low < index - 1)//to avoid index out of bond
				quickSort(input, low, index - 1);
			if (high > index)
				quickSort(input, index, high);

		}
		return input;
	}

	private static int getPivot(int[] a, int low, int high) {
		int i = low;
		int j = high;
		// move i to a place until element left of i are < a[i] && right are more than
		// it
		int p = a[(low + high) / 2];
		while (i <= j) {
			while (a[i] < p)
				i++;
			while (a[j] > p)
				j--;

			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}

		return i;
	}

}
