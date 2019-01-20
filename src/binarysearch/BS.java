package binarysearch;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import binarytree.BinaryTree.Tree;

public class BS {

	public static void main(String[] args) {
		
		int a[]= {2,4,6,7,8,9};
		
		System.out.println(bs(a,8));
		//create BST from sorted array
		Tree<Integer> root=buildBST(a);
		printBFS(root);
		printDFS(root);
	}
	private static void printDFS(Tree<Integer> root) {
		//list contains all visited nodes	
				List<Tree<Integer>> visited=new LinkedList<>();
				//list contains nodes to be visited in next level
				List<Tree<Integer>> unvisted=new LinkedList<>(Arrays.asList(root));
				
				while(!unvisted.isEmpty()) {
					Tree<Integer> node=unvisted.remove(0);
					System.out.print(node.value+" ");
					List<Tree<Integer>> newnodes=node.getChildren().stream()
									.filter(e->!visited.contains(e))
									.collect(Collectors.toList());
					
					visited.add(node);
					
					unvisted.addAll(0,newnodes);
					
				}
		
	}
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
		
	
	private static Tree<Integer> buildBST(int[] a) {
		
		return createBST(a,0,a.length-1);
	}
	/**
	 * recursion 
	 * @param a
	 * @param start
	 * @param end
	 * @return
	 */
	private static Tree<Integer> createBST(int[] a, int start, int end) {
		if(start>end)
			return null;
		if(start==end)
			return new Tree<Integer>(a[start]);
		int mid=start+(end-start)/2;
		Tree<Integer> root=new Tree<Integer>(a[mid]);
		root.left=createBST(a,start,mid-1);
		root.right=createBST(a,mid+1,end);
		return root;
	}
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
	

	private static int bs(int[] a, int n) {
		
		int start=0,end=a.length-1;
		int mid=start+(end-start)/2;
		while(start<=end)
		{
			 mid=start+(end-start)/2;
			if(a[mid]==n)
			  return mid;
			else if(a[mid]<n)
				mid=mid+1;
			else end=mid-1;
			
		}
		
		return -1;
	}

}
