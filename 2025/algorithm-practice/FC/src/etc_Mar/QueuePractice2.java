package etc_Mar;
 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
public class QueuePractice {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Queue<Integer> qu = new LinkedList<Integer>();
		
		//인큐 : add, offer
		//디큐 : poll, remove
		
		//배열 -> for문
		for (int i = 0; i < arr.length; i++) {
			if
		}
	}
}
*/

public class QueuePractice2<T> {
	private ArrayList<T> queue = new ArrayList<T>();
	
	public void enqueue(T item) {
		queue.add(item);
	}
	 
	public T dequeue() {
		if(queue.isEmpty()) {
			return null;  
		}
		return queue.remove(0);  
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	} 
	
	public static void main(String[] args) { 
		QueuePractice2<Integer> qp = new QueuePractice2<Integer>();
		qp.enqueue(1);
		qp.enqueue(2);
		qp.enqueue(3);
		
		System.out.println(qp.dequeue());
		System.out.println(qp.dequeue());
		System.out.println(qp.dequeue());
	}
}
