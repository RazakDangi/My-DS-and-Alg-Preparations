package sorting;
import java.util.Scanner;
import java.util.stream.Stream;

public class MergeSort {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		String in=scanner.nextLine();
		scanner.close();
		
		int[] a=Stream.of(in.split(" ")).limit(n).mapToInt(Integer::valueOf).toArray();
		int[] res=mergeSort(a);
		Stream.iterate(0, i->i+1).limit(res.length).forEach(i->System.out.print(res[i]+" "));
	}

	private static int[] mergeSort(int[] a) {
		if(a.length<2)
			return a;
		else {
		int index = a.length/2;
		int left[]=new int[index];
		int right[]=new int[a.length-index];
		System.arraycopy(a, 0, left, 0, index);
		System.arraycopy(a, index,right,0,a.length-index);
		
		return merge(mergeSort(left),mergeSort(right));
		
		}
		
	}

	private static int[] merge(int[] a, int[] b) {
		int result[]=new int[a.length+b.length];
		
		int idxA=0;
		int idxB=0;
		int k=0;
		while(idxA<a.length && idxB<b.length)
		{
			if(a[idxA]<b[idxB])
				result[k++]=a[idxA++];
			else
				result[k++]=b[idxB++];
		}
		while(idxA<a.length)
			result[k++]=a[idxA++];
		while (idxB<b.length) {
			result[k++]=b[idxB++];
		}
					
		return result;
	}

}
