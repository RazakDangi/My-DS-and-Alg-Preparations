package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InteresectionArrayInt {

	public static void main(String[] args) {
		
		List<Integer> l1=Arrays.asList(1,2,3,5,7);
		
		List<Integer> l2=Arrays.asList(0,3,5,7,8);
		
		List<Integer> result=new ArrayList<>();
		l1.stream().forEach(i->
				l2.stream().forEach(j->{if(i==j) result.add(i);}  ));
		
		result.stream().forEach(System.out::print);
		
		System.out.println();
		
		l1.stream().filter(e->l2.contains(e))
		.forEach(System.out::print);

	}

}
