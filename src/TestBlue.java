import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class TestBlue {

	 public static void main(String args[] ) throws Exception {
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int t = Integer.parseInt(br.readLine().trim());
	        for (int i_t = 0;i_t < t;++i_t) {
	            String[] temp = br.readLine().split(" ");
	            int n = Integer.parseInt(temp[0]);
	            int m = Integer.parseInt(temp[1]);
	            int []X = new int[m];
	            int []Y = new int[m];
	            for (int i = 0;i < m;++i) {
	                temp = br.readLine().split(" ");
	                X[i] = Integer.parseInt(temp[0]);
	                Y[i] = Integer.parseInt(temp[1]);
	            }
	            System.out.println(solve(n, m, X, Y));
	        }
	        

	    }
	  static class Tree{
			Integer value;
			List<Tree> edges;
			
			public Tree(Integer value) {
				this.value = value;
				this.edges=new ArrayList<>();
			}

			public List<Tree> getEdges() {
				return edges;
			}

			public void setEdges(List<Tree> edges) {
					this.edges = edges;
			}

			public Integer getValue() {
				return value;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((value == null) ? 0 : value.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Tree other = (Tree) obj;
				if (value == null) {
					if (other.value != null)
						return false;
				} else if (!value.equals(other.value))
					return false;
				return true;
			}
			
			
			
		}
	    static String solve(int n, int m, int []X, int []Y) {
	       //lets create a Tree
	    	return checkCanVisit(X,Y,n);
	    	
	    }
		private static String checkCanVisit(int[] x, int[] y,int n) {
			Set<Tree> nodes1=Arrays.stream(x).mapToObj(i->new Tree(i)).collect(Collectors.toSet());
			Set<Tree> nodes2=Arrays.stream(y).mapToObj(i->new Tree(i)).collect(Collectors.toSet());
			nodes1.addAll(nodes2);
			
			//lets add eadges for each node
			nodes1.stream().forEach(node-> nodes2.stream().forEach(edje->{if(!node.equals(edje)) {node.getEdges().add(edje); edje.getEdges().add(node);}}));
			
			Set<Tree> visited=new HashSet();
			//list contains nodes to be visited in next level
			List<Tree> unvisted=new ArrayList<>(nodes1);
			
			while(!unvisted.isEmpty()) {
				Tree node=unvisted.remove(0);
								
				List<Tree> newnodes=node.getEdges().stream()
								.filter(e->!visited.contains(e))
								.collect(Collectors.toList());
							
				visited.add(node);
					newnodes.remove(node);
					
				
				unvisted.addAll(0,newnodes);
				
			}
			if(n==visited.size()) return "Yes";
			else return "No";
			
		}
}
