package ex18lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;


public class Ex06Define2Supplier {
	/*
	Suppiler<T>
		: 공급자란 의미를 가지고 있고
		매개변수는 없으나 리턴값은 있는 getXXX()메소드가 정의되어있다.
		주로 실행 후 생성한 데이터를 반환한다. 
	 */
	public static void main(String[] args) {
		/*
		Interface Supplier<T> {
			T get();
		}
		*/
		//100이하의 난수를 생성해주는 람다식 정의
		Supplier<Integer> sup = () -> {
			Random random = new Random();
			return random.nextInt(100);
		};		
		int rNum = sup.get();  
		System.out.println("생성된난수="+ rNum);		
		
		//10개의 난수를 생성한 후 List컬렉션으로 반환받음.
		List<Integer> list = makeRandomNum(sup, 10);
		System.out.println("### print문으로 출력1");
		System.out.println(list);//단순히 컬렉션을 출력만 하는 용도로 사용
				
		System.out.println("### foreach문으로 출력2");
		for(Integer i : list) {
			System.out.printf("%d ", i);
		}
		System.out.println();
				
		System.out.println("### 이터레이터로 출력3");
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() +" ");
		}
	}
	
	/*
	100이하의 난수를 생성하는 람다식과 정수를 인수로 받아
	정수만큼의 난수를 생성한 후 List컬렉션으로 반환한다.
	 */
	public static List<Integer> makeRandomNum(Supplier<Integer> s, 
			int cnt){		
		List<Integer> li = new ArrayList<Integer>();
		for(int i=1 ; i<=cnt ; i++) {
			/*
			매개변수로 전달된 람다식 s를 통해 난수를 생성한 후
			리스트 컬렉션에 저장한다. 
			*/
			li.add(s.get());
		}
		
		return li;
	}
}
