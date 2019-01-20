package edxAlgJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


public class MaxPairwiseProduct {

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int N = scanner.nextInt();

		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(getMin(input));
		System.out.println(getMin8(input));
	}

	private static int getMin(int[] input) {
		int size = input.length;
		
		int min=Integer.MAX_VALUE;

		for (int i = 0; i < size; i++) {
			if (input[i] % 2 !=0  && input[i]<min) {
				min=input[i];
				} 
		}
		return min;
	}
	
	private static int getMin8(int[] input) {
		int size = input.length;
		
		int min=Integer.MAX_VALUE;

		return IntStream.of(input).filter(i->i %2 !=0)
		.min().getAsInt();
		
	}


	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() {

			try {
				while(st==null || !st.hasMoreElements())
				st = new StringTokenizer(br.readLine());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public void close() {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
