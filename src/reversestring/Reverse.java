package reversestring;

import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reverse {

	public static void main(String[] args) {
	
		                    
		String s="hello";
		String r="";
		for(String ch:s.split(""))
		{
			r=ch+r;
		}
		System.out.println(r);
		
		System.out.println(Stream.of(s.split("")).reduce("",(rev,ch)->ch+rev));
		
		
		System.out.println(Stream.of(s.split(""))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
	}

}
