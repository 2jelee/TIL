package etc_Mar;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain2 {
	public static void main(String[] args) {
		Queue<Integer> queue_int = new LinkedList<Integer>();
		Queue<String> queue_str = new LinkedList<String>();
		 
		queue_int.add(1);
		queue_int.offer(2);	 
		System.out.println("add/offer한 값 확인하기 : "+queue_int); 
		 
		queue_int.poll();
		System.out.println("poll 후 값 확인하기 : " +queue_int);
		queue_int.remove();
		System.out.println("remove 후 값 확인하기 : " +queue_int);  
	}
}
