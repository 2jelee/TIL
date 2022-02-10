package ex01.collection.set;

/*
 * [Collection] 	-자료구조			 
 * data? 자료?
 * 
 * 자료구조?
 * 		data를 시스템에 효율적으로 저장하기 위한 방법
 * 알고리즘?
 * 		어떠한 문제를 풀어내기 위해 정해진 일련의 절차나 방법
 * 
 * Collection		 (특징)
 * 1) set (type)
 * 				 	: 순서 X
 * 					  중복 허용 X	
 * 
 * 					  데이터를 자체적으로 꺼낼 수 X
 * 				 	  interator라는 메소드의 도움을 받아 data를 추출
 * 
 *					  클래스 : HashSet / TreeSet
 * 
 * 2) List (type)	
 * 				 	: 순서 O
 * 					  중복 허용 O

					  데이터 자체적 꺼낼 수 O
					  get 메소드 사용
 * 
 * 3) Map (type)	>> set과 List의 결합형태	key값으로 value값을 따라감	>> key와 value 한쌍으로 이루어진다.
 * 												key값은 set의 특징을 따라감 (순서,중복X)
 * 												value : List의 특징을 따라감(중복O)
 * 				 	: 순서 O					
 * 					  중복 허용 O
 * 
 * 					  key -> iterator 
 * 					  value -> iterator, get 모두 O
 */

import java.util.HashSet;
import java.util.Set; 

//1. Set : 순서 X, 중복허용 X
public class MainEntry1 {
	public static void main(String[] args) {
		//모든 데이터 받는 상태로 만들기 >> Object
		Object[] objArr = {"1", new Integer(1), "2", "3", "3", "4", "t", "4", 1, 1.234};		//실수도 O => Object type이므로 모든 데이터 넣을 수 있다.
		Set set = new HashSet();
		for (int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]);
		}
		System.out.println(set); //자료형이 다르기때문에 출력결과 1(문자), 1(숫자)	=> 단, new Integer(1)과 뒤의 1에서는 뒤에 나오는 것이 앞을 덮어쓴다.
																				//  => 즉, 실수 앞의 1이 나온것임
	}
}
