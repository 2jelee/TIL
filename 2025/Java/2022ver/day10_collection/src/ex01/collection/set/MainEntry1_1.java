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
import java.util.Iterator;

//1. Set : 순서 X, 중복허용 X
public class MainEntry1_1 {
	public static void main(String[] args) { 
//		HashSet<String> hs = new HashSet();			//타입 지정 안했음
		HashSet<String> hs = new HashSet<String>();
		hs.add("키보드");
		hs.add("마우스");
		hs.add("플라밍고");
		hs.add("컵");
		hs.add("키보드");
		//string 타입이므로 X
//		hs.add(12.34);
		
		/*
		 *  wrapper 클래스 : 기본 자료형에 대응되는 클래스형 자료형
		 *  기본자료형  			클래스형(레퍼런스 또는 참조형)자료형
		 *  int						Integer
		 *  float					Float
		 *  char					Character
		 *  double					Double
		 *  ...						...
		 *  
		 *  						사용자가 만든 데이터 타입도 들어갈 수 있다!
		 */  
		// wrapper에 의해 <>안에 int(기본자료형_primitive type) X => Integer(reference type) O
		HashSet<Integer> hs2 = new HashSet<Integer>();	//
		hs2.add(100);
		hs2.add(1000);
//		hs2.add(12.34);
		hs2.add(100);
		hs2.add(3);
		
		
		System.out.println("요소(해당데이터)의 갯수 : " + hs.size()); 		//출력 결과 : 4 (중복 허용 X이므로)
		
		Iterator it = hs.iterator(); 		//타입 지정 X
		while (it.hasNext()) {				//hasNext : 추상메소드임 		//의미 : 다음 요소가 있다면
			System.out.println(it.next()); 		//출력결과 : 플라밍고 컵 키보드 마우스
		}
		System.out.println("-----------------------------------");
		
		//foreach문
		for(Object item : hs2) {
			System.out.println(item);			//넣었던 순서대로 나오지는 X
		}

		System.out.println("-----------------------------------");
		
		System.out.println(hs);

		System.out.println("-----------------------------------");
		it = hs2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
