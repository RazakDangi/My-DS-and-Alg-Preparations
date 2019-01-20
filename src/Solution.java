
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static class Tree{
	public int x;
	public Tree l;
	public Tree r;
	}
	
	public static void main(String[] args) {
		Tree t=null;
		int x=solution(t);
	}

	private static int solution(Tree T) {
		if (T == null)
			return 0;
		Set<Integer> uniqueSet = new HashSet<>();

		return getMaxUniquePath(T, uniqueSet);
	}

	private static int getMaxUniquePath(Tree t, Set<Integer> uniqueSet) {
		if (t == null)
			return uniqueSet.size();
		int maxl = 0;
		int maxR = 0;
		if (uniqueSet.add(t.x)) {
			maxl = getMaxUniquePath(t.l, uniqueSet);
			maxR = getMaxUniquePath(t.r, uniqueSet);
			uniqueSet.remove(t.x);
		} else {
			maxl = getMaxUniquePath(t.l, uniqueSet);
			maxR = getMaxUniquePath(t.r, uniqueSet);
		}

		return Math.max(maxl, maxR);
	}
}
