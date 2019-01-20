import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.plaf.synth.SynthStyle;

public class StringToCharHashMap {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		String input=scanner.next();
		scanner.close();
		Map<String, Long> map=
		 Stream.of(input.split(" "))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

		//first non repeating charecter
		System.out.println(map.entrySet().stream().filter(e->e.getValue()==1).findFirst());
		
		//map iterate using biConsumer
		//map.forEach((key,value)->System.out.println("Key "+key+ " Value "+value));
		
		//reverse string 
		System.out.println(Stream.of(input.split("")).reduce((rev,ch)->ch+rev));
		
		//print only repeating chars
		map.entrySet().stream().filter(e->e.getValue()>1).map(e->e.getKey()).forEach(System.out::println);
		//print only non repeating char
		map.entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey()).forEach(System.out::println);
		
		//recursively remove substring
		System.out.println(recursiveRemove(input,"ab"));
		
		//Optional<String[]> com=Stream.of(input.split("")).flatMap(i->Stream.of(input.split("")).map(j->new String[]{i,j}))
		//.collect(Collectors.reducing((a,b)->merge(a,b)));
		
		permutationsOfString(input);
		//System.out.println(Stream.of(input.split("")).filter(ch->!ch.contains("a")).collect(Collectors.joining()));
		
	}
private static String[] merge(String[] a, String[] b) {
		String[] result = new String[a.length + b.length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}
private static String permutationsOfString(String input) {
		
		recursivePermutations("",input);
		return null;
	}
/*input abc
i=0;("","abc")->("a","bc")->("ab","c")->("abc","") print abc
i=1;("ac","b")->("acb","")->print acb									
i=1;("","abc")->("b","ac")->("ba","c")->("bac","")->print bac
i=1;("bc","a")->("bca","")->print bca

i=2;("","abc")->("c","ab")->("ca","b")->("cab","")=>print cab
 i=1;("cb","a")->("cba","")->print cba
*/	private static void recursivePermutations(String perm, String input) {
	
		if(input.isEmpty())
			System.out.println(perm+input);
		
		else{for(int i=0;i<input.length();i++)
			recursivePermutations(perm+input.charAt(i),input.substring(0,i)+ input.substring(i+1, input.length()));
		}
}
	/*
	 * input=>xyzabpqrabxyz
	 * indexOf(ab)=3 ->rec(xyz)+rec("pqrabxyz")
	 * 
 * divide string on matched character into two sub strings
 */
	private static String recursiveRemove(String input, String string) {
		//
		int index=input.indexOf(string);
		if(index==-1)
			return input;
		return recursiveRemove(input.substring(0, index), string)+
				recursiveRemove(input.substring(index+string.length(),input.length()),string);
	}

}
