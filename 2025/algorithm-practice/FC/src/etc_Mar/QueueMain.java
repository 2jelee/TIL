package etc_MAR;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {
	public static void main(String[] args) {
		Queue<Integer> queue_int = new LinkedList<Integer>();
		Queue<String> queue_str = new LinkedList<String>();
		
		// 데이터 추가는 add(value) 또는 offer(value)
		queue_int.add(1);
		queue_int.offer(2);	// 출력에 true 라고 출력되는 부분은 offer() 메서드가 리턴한 값으로, 
		System.out.println("add/offer한 값 확인하기 : "+queue_int);
		// 셀의 맨 마지막에 함수를 넣을 경우, 변수가 변수값이 출력되는 것처럼 함수는 함수 리턴값이 출력되는 것임
		
		// 데이터 삭제는 poll() 또는 remove()
		queue_int.poll();
		System.out.println("poll 후 값 확인하기 : " +queue_int);
		queue_int.remove();
		System.out.println("remove 후 값 확인하기 : " +queue_int); //현재 결과 : 모두 삭제됨
	}
}
