import java.awt.DisplayMode;

import reversestring.Reverse;

public class LinkedListReverse {
	
	public static void main(String[] args) {
		
		Node n1=new Node<Integer>(1);
		Node n2=new Node<Integer>(2);
		Node n3=new Node<Integer>(3);
		
		LinkedList l1=new LinkedList();
		l1.add(n1);
		l1.add(n2);
		l1.add(n3);
		
		System.out.println(l1.toString());
		
		//Node rev=l1.reverse();
		
		//display(rev);
		display(l1.reverseRec(l1.start));
	}

	private static void display(Node rev) {
		
		StringBuilder builder=new StringBuilder();
		Node temp=rev;
		while(temp!=null) {
			builder.append(temp.data+"-> ");
			
			temp=temp.next;
		}
		builder.append("null");
		System.out.println(builder.toString());
	}

	
}

class LinkedList<T>{
	Node<T> start;
	LinkedList(){
		start=null;
	}
	LinkedList(Node node){
		start=node;
		
	}
	public void add(Node node) {
		Node temp=start;//to keep start always at 1st element
		if(temp==null) {
			start=node;
		}
		else{
			while(temp.next !=null)
				temp=start.next;
			
			temp.next=node;
		}
	}
	
	public Node reverseRec(Node node) {
		if(node ==null)
			return null;
		if(node.next==null)
			return node;
		else {
			Node ret=reverseRec(node.next); //r(1)->r(2)->r(3)  //n*rec(n-1) //f(n-1)+f(n-2)  //n+rec(n-1)//reverse enginering
			node.next.next=node;//???
			node.next=null;
			return ret;
		}
		
	}
	public Node reverse() {
		Node cur=start;
		Node next=null;
		Node prev=null;
		
		while(cur!=null) {
			next=cur.next;
			cur.next=prev;
			prev=cur;
			cur=next;
		}
		
		return prev;
		
	}
	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		Node temp=start;
		while(temp!=null) {
			builder.append(temp.data+"-> ");
			
			temp=temp.next;
		}
		builder.append("null");
		return builder.toString();
	}
	/*public reverse()*/
}
class Node<T>{
	T data;
	
	Node next;
	Node(T v)
	{
		data=v;
		next=null;
	}
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	
}
