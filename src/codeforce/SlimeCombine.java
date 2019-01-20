package codeforce;

import java.util.Scanner;
import java.util.stream.Stream;

public class SlimeCombine {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();	
		if(n==1 || n== 2)
			System.out.println(n);
		int[] values=Stream.iterate(1, i->i)
		.limit(n).mapToInt(i->i).toArray();
		
				
	     slimeCombine(values);
		scanner.close();
	}

	private static void slimeCombine(int[] values) {
		StringBuilder r=new StringBuilder();
		for(int i=values.length-1;i>0;i-- )
		{
			if(values[i]==values[i-1]) {r.append(values[i-1]+1);}
			else {values[values.length-1]=values[i-1];values[i-1]=0;}
		}
	
		for(int i=0;i<values.length;i++)
		{
			if(values[i]!=0) System.out.print(values[i]+" ");
		}
	}

}
