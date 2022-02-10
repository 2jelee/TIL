package ex04.list;

import java.util.*;

// ★★★ Stack vs Queue

class StackQueueEx {
	public static void main(String[] args) {
		Stack st = new Stack();			//LIFO
		// LinkedList는 Queue 인터페이스를 구현하였다
		Queue q = new LinkedList();		//FIFO
		
		// ?? List를 상속받았으므로 이들은 모두 get으로 꺼내면 선입선출 상관없이 index번호로 꺼내짐
		
		st.push("0");
		st.push("1");
		st.push("2");

		q.offer("0");
		q.offer("1");
		q.offer("2");

		System.out.println("= Stack =");
		while(!st.empty()) {
			System.out.println(st.pop());	// 결과 : 2, 1, 0
		}

		System.out.println("= Queue =");
		while(!q.isEmpty()) {
			System.out.println(q.poll());	//poll : 데이터 꺼내는		//결과 : 0, 1, 2
		}
	}
}