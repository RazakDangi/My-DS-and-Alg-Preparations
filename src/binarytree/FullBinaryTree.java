package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FullBinaryTree {

	static class Tree{
		int value;
		Tree left,right;
		
		List<Tree> getChildern(){
			return Stream.of(left,right)
					.filter(Objects::nonNull)
					.collect(Collectors.toList());
		}
		public Tree(int value) {
			super();
			this.value = value;
			left=null;
			right=null;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Tree getLeft() {
			return left;
		}
		public void setLeft(Tree left) {
			this.left = left;
		}
		public Tree getRight() {
			return right;
		}
		public void setRight(Tree right) {
			this.right = right;
		}
		
	}
	
	public static void main(String[] args) {
		
		Tree r=new Tree(1);
		
		Tree l1=new Tree(2);
		Tree r1=new Tree(3);
		
		r.left=l1;
		r.right=r1;
		
		l1.left=new Tree(4);
		l1.right=new Tree(5);
		
		r1.left= new Tree(6);
		
		Tree x=new Tree(7);
		Tree y=new Tree(8);
		r1.right=x;
		x.right=y;
		y.right=new Tree(9);	
		System.out.println(isFullBT(r));
		System.out.println(isBalancedBT(r));
		System.out.println(height(r.left));
		System.out.println(height(r.right));
		System.out.println(sum(r));
		printDFT(r);
		System.out.println();
		printBFS(r);
		System.out.println(maxDepath(r));
		System.out.println(height(r));
		
		
	}

	private static List<Integer> getOdd(List<Integer> list) {
		return list.stream().filter(e->e%2!=0)
		.collect(Collectors.toList());
		
	}

	private static List<Integer> getEven(List<Integer> list) {
		List<Integer> even=new ArrayList<>();
		for(Integer e:list)
		{
			if(e%2==0)
				even.add(e);
		}
		return even;
	}

	private static void printDFT(Tree r) {
		
		List<Tree> visited=new LinkedList<>();
		List<Tree> unvisited=new LinkedList<>();
		unvisited.add(r);
		while(!unvisited.isEmpty())
		{
			Tree node=unvisited.remove(0);
			System.out.print(node.value +" ");
			//lets calculate next nodes
			List<Tree> nextNodes=node.getChildern().stream().filter(e->!visited.contains(e))
					 .collect(Collectors.toList());
			unvisited.addAll(0,nextNodes);
			
			visited.add(node);
		}
	}
	private static void printBFS(Tree r) {
		
		List<Tree> visited=new LinkedList<>();
		List<Tree> unvisited=new LinkedList<>();
		unvisited.add(r);
		while(!unvisited.isEmpty())
		{
			unvisited.stream().forEach(e->System.out.print(e.value+" "));
			
			//lets calculate next nodes
			List<Tree> nextNodes= unvisited.stream()
					.map(e->e.getChildern())
					.flatMap(List::stream)
					.collect(Collectors.toList());
					
			visited.addAll(unvisited);	
			
			unvisited=nextNodes;
			
			
		}
	}

	private static int sum(Tree r) {
		if(r==null ) return 0;
		return r.value+sum(r.left)+sum(r.right);
	}

	private static boolean isBalancedBT(Tree r) {
		if(r==null) return true;
		
		if (Math.abs(height(r.left) -height(r.right)) > 1) 
		return false;
		
		return true;
		
				
	}
	
	private static int maxDepath(Tree r) {
		if(r==null) return 0;
		return 1+Math.max(height(r.left), height(r.right));
	}


	private static int height(Tree r) {
		if(r==null) return -1;
		return 1+Math.max(height(r.left), height(r.right));
	}

	private static boolean isFullBT(Tree r) {
		if(r ==null) return true;
		if((r.left ==null && r.right !=null) ||
				(r.right==null && r.left!=null) ) return false;
		
		return isFullBT(r.left) && isFullBT(r.right);
	}
}
