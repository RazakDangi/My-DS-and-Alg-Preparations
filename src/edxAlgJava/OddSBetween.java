package edxAlgJava;

import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddSBetween {

	
	
	  static List<Integer> oddNumbers(int l, int r) {
		  IntPredicate predicate = new IntPredicate()
		    {
		        @Override
		        public boolean test(int value)
		        {
		            return value % 2 == 0;
		        }
		    };
			return IntStream.rangeClosed(l,r)
		    .filter(predicate)
		    .boxed().collect(Collectors.toList());
		    
		        

	  }
	  
	  static String findNumber(List<Integer> arr, int k) {
		  
		  Optional<Integer> optional = arr.stream().filter(t->t==k).findFirst();
		  		  
		return optional.isPresent()==true?"YES":"NO";


	    }
}
