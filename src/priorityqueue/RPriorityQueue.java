package priorityqueue;

public class RPriorityQueue<T> {

	static class Node<T>{
		T value;
		int priority;
		Node<T> next;
		public Node(T value, int priority) {
			
			this.value = value;
			this.priority = priority;
			this.next=null;
		}
		
		
	}
	static class MyPriorittyQ<T>{
		Node<T> front;
		Node<T> tail;
		int size=0;
		
		/*
		 * lower int has more priority
		 * tryto insert front or at tail is elibiable priority is first or last
		 * else
		 * find middle place where new node will be inserted.
		 */
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
