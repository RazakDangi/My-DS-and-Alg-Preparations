package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TestDBS {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String in = scanner.nextLine();
		scanner.close();
		int[] input = Stream.of(in.split(" ")).mapToInt(Integer::valueOf).toArray();

		//Stream.iterate(0, i -> i + 1).limit(input.length).forEach(i -> System.out.print(input[i] + " "));
		
		Arrays.stream(input).forEach(System.out::print);

	}
	
	

}
