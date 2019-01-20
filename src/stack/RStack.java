package stack;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import junit.framework.Assert;

public class RStack<T> {

	static class Node<T>{
		T value;
		Node<T> next;
		public Node(T value) {
				this.value = value;
				this.next=null;
		}
		
	}
	static class MyStack<T>{
		Node<T> topNode;
		int size;
		
		public MyStack() {
			this.topNode = null;
			this.size = 0;
		}
		public boolean isEmpty() {
			return this.size==0;
		}
		public T pop() {
			if(isEmpty())
				return null;
			else {
				T value=this.topNode.value;
				this.topNode=this.topNode.next;
				this.size--;
				return value;
			}
		}

		public void push(Node<T> node)
		{
			if(isEmpty())
				{this.topNode=node;
				this.size++;
				}
			else {
				node.next=this.topNode;
				this.topNode=node;
				this.size++;
			}
		}
		public T peek() {
			return isEmpty()==true?null:this.topNode.value;
		}
	}
	
	static class MyQueue<T>{
		Node<T> front;
		Node<T> tail;
		int length;
		
		MyQueue(){
			this.front=null;
			this.tail=null;
			this.length=0;
		}
		public void enque(Node<T> node) {
			if(this.length==0) {
				this.front=node;
				this.tail=node;
			}
			else {
					this.tail.next=node;
				   this.tail=node;
			}
			this.length++;
		}
	}
	public static void main(String[] args) {
	
		MyStack<Integer> stack=new MyStack<Integer>();
		System.out.println(stack.isEmpty());
			
		stack.push(new Node<Integer>(1));
	
		System.out.println(stack.isEmpty());
		
		IntStream.rangeClosed(1, 100).forEach(i->stack.push(new Node<Integer>(i)));
		Stream.iterate(0, i->i+1).limit(100).forEach(i->System.out.print(stack.pop()));
		
	}

}
