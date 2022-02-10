package ex02.collection.list;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

/*
 * 2) List : 순서 O, 중복허용 O
 * -변수 => 배열(고정길이) => 가변길이
 * int[] arr = new int[90];
 * 
 * Vector <--- jdk 1.x, 가변길이, 동기화 지원 O	(동기화 << thread-safe)
 * ArrayList <--- jdk 2.x, 가변길이, 동기화 지원 X
 * 				  검색, 대량의 데이터 삽입/삭제
 * LinkedLIst <--- data 삽입/삭제 수월
 * 
 *  
[Vector() 클래스의 주요 메소드]
addElement(객체)
	:객체를 Vector에 저장합니다.

elementAt(int)
	:몇번째 벡터값 요소를 확인합니다.

capacity()
	:벡터의 크기를 확인합니다.
 
 
>> 보통 Vector() 클래스는 <객체>를 사용하여 어떤 type의 객체를 생성할지 나타냄
 
 
 

 * 3) Map : key/value 한 쌍으로 처리 (set + list)
 */

public class VectorEx01 {
	public static void main(String[] args) {
		Vector<Integer> vec = new Vector<Integer>();
		System.out.println(vec.size() + "  /  " + vec.capacity());
		
		Vector<Integer> v = new Vector<Integer>(3, 4); 		//초기용량, 증가용량
		v.add(2);
		v.add(new Integer(333));
		v.add(20);
		v.add(2);
		v.add(55);
		v.add(12);
		System.out.println(v.size() + "  /  " + v.capacity());
		
		System.out.println("---------------- iterator() method ----------------");
		Iterator it = v.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());			//중복 허용됨을 알 수 있다.
		}

		System.out.println("---------------- get() method ----------------");
		for (int i = 0; i < v.size(); i++) {	//요소 수를 가져오자 >> size
			System.out.println(v.get(i));
		}
		
		System.out.println("---------------- sort() method ----------------");
		// -s붙은 것은 class다.
		Collections.sort(v);					//오름차순 정렬
		for (int i = 0; i < v.size(); i++) {	 
			System.out.println(v.get(i));
		}

		System.out.println("---------------- elementsAt() method ----------------");
		for (int i = 0; i < v.size(); i++) {	 
			Integer num = v.elementAt(i);
//			System.out.println(num);
			System.out.println(num.toString());
		}
		
		System.out.println("---------------- trimToSize() method ----------------");
		System.out.println(v.size() + "   /   " + v.capacity());		//6   /   7
		v.trimToSize(); 	//capacity 조정하기
		System.out.println(v.size() + "   /   " + v.capacity());		//6   /   6 >> 결과 : 줄어듦을 확인 
	}
}
