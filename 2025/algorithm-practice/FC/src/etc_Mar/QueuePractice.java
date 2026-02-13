package etc_MAR;

/*
연습해보기

- JAVA ArrayList 클래스를 활용해서 큐를 다루는 enqueue, dequeue 기능 구현해보기
- dequeue 기능 호출 시, 큐에 데이터가 없을 경우, null 을 리턴하도록 함
- 다양한 데이터 타입을 다룰 수 있도록, Java Genric 타입 문법을 활용해보기
*/
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

public class QueuePractice<T> {
	private ArrayList<T> queue = new ArrayList<T>();
	
	public void enqueue(T item) {
		queue.add(item);
	}
	
	//데이터를 꺼내오므로 인자 X
	public T dequeue() {
		if(queue.isEmpty()) {
			return null; //ArrayList의 isEmpty라는 메서드는 ArrayList가 비어있으면 true를 리턴해준다. 
		}
		return queue.remove(0); //그렇지 않으면 0번(맨앞 데이터) 인덱스(ArrayList이므로 index 사용)를 삭제하라.
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	// QueuePractice라는 클래스가 데이터가 있는지 없는지 추가적으로 판단할 수 있는 메서드
	
	public static void main(String[] args) {
		//test code	
		QueuePractice<Integer> qp = new QueuePractice<Integer>();
		qp.enqueue(1);
		qp.enqueue(2);
		qp.enqueue(3);
		
		System.out.println(qp.dequeue());
		System.out.println(qp.dequeue());
		System.out.println(qp.dequeue());
	}
}
