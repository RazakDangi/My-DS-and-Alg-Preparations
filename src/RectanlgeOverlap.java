import javax.swing.plaf.synth.SynthStyle;

/*
 * Given two rectangles, find if the given two rectangles overlap or not.
Note that a rectangle can be represented by two coordinates, top left and bottom right. So mainly we are given following four coordinates.
l1: Top Left coordinate of first rectangle.
r1: Bottom Right coordinate of first rectangle.
l2: Top Left coordinate of second rectangle.
r2: Bottom Right coordinate of second rectangle.
 */
public class RectanlgeOverlap {

	public static void main(String[] args) {
		
		
		int[] l1=new int[] {2,5};
		int[] r1=new int[] {5,2};
		int[] l2=new int[] {3,4};
		int[] r2=new int[] {7,4};
		System.out.println(doOverlap (l1, r1, l2, r2));

	}

	private static boolean doOverlap(int[] l1, int[] r1, int[] l2, int[] r2) {
		
		if(r1[0]-l2[0]>0 && l2[1]-r1[1]>0)
			return true;
		return false;
		
	}

}
