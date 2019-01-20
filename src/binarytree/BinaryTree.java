package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryTree<T> {

	public static class Tree<T>{
		T value;
		Tree<T> left,right;
		
		public Tree(T value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		@SuppressWarnings("unchecked")
		public List<Tree<T>> getChildren(){
			return (List<Tree<T>>) Stream.of(left,right)
					.filter(Objects::nonNull)
					.collect(Collectors.toList());
		}
		
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Tree<Integer> root=new Tree<>(2);
		Tree<Integer> l1=new Tree<>(1);
		Tree<Integer> r1=new Tree<>(3);
		root.left=l1;
		root.right=r1;
		
		l1.left=new Tree<>(0);
		l1.right=new Tree<>(7);
		r1.left=new Tree<>(9);
		r1.right=new Tree<>(1);
		
		printBFS(root);

	}
	/**
	 * BFS or level order print
	 * @param root
	 */
	private static void printBFS(Tree<Integer> root) {
	//list contains all visited nodes	
	List<Tree<Integer>> visited=new LinkedList<>();
	//list contains nodes to be visited in next level
	List<Tree<Integer>> unvisted=new LinkedList<>(Arrays.asList(root));
	
	while(!unvisted.isEmpty()) {
		//to print in order of output 
		final StringBuilder builder=new StringBuilder();
		unvisted.stream().forEach(e->{
			builder.append("(").append(e.value).append(")");
			builder.append(",");
		});
		//need to remove last comma before printing
		System.out.println(builder.toString().substring(0, builder.toString().length()-1));
		//get all next level nodes
		List<Tree<Integer>> newNodes=unvisted.stream()
									.map(e->e.getChildren())
									.flatMap(List::stream)
									.collect(Collectors.toList());
		//make current level nodes as visited
		visited.addAll(unvisted);
		//new nodes to be visited in next level		
		unvisted=newNodes;
	}
		
	}

}
