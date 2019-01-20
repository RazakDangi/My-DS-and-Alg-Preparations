import java.nio.file.DirectoryStream.Filter;
import java.util.Optional;
import java.util.stream.IntStream;

public class UniqueCharDetectorASCI {

	public static void main(String[] args) {
		
		String a="abcdefgh";
		String b="abcdefghab";
		
		System.out.println(uniqueDetectorOldway(a));
		
		/*System.out.println(uniqueDetector(b));*/
		System.out.println(uniqueDetectorOldway(b));
	}

/*	private static Boolean uniqueDetector(String a) {
		final boolean[] array=new boolean[128];
		 return IntStream.range(0, a.length())
		.mapToObj(i->array[a.charAt(i)])
		.filter(v->v==true)
		.findFirst().orElse(true);
		
	}*/
	private static Boolean uniqueDetectorOldway(String a) {
		final boolean[] array=new boolean[128];//all false 
	
		for(int i=0;i<a.length();i++) {
			int val=a.charAt(i);
			if(array[val])
				return false;//if it has come already duplcaite
			array[val]=true;//put true when it comes for first time
		}
		return true;
}
	
}