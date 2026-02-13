package ex01.collection.set;

/*
 *  [HashSet vs TreeSet]
 *  TreeSet : 자동정렬 O
 */
import java.util.TreeSet;


public class TreeSetMain {
	public static void main(String[] args) {
		//타입 제한없이 사용
		TreeSet set = new TreeSet();
		
		int[] score = {85, 95, 50, 35, 45, 65, 10, 100};
		
		for (int i = 0; i < score.length; i++) {
//			set.add(score[i]);
			set.add(new Integer(score[i]));
		}
		
		System.out.println(set);	//결과 : 자동정렬 됨
		
		System.out.println("50보다 작은 값 : " + set.headSet(new Integer(50)));
		System.out.println("60보다 큰 값 : " + set.tailSet(new Integer(60)));
	}
}
