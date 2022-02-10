package ex05.collection.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapMain {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
//		HashMap<String, Integer> hm = new HashMap();	//가능
		
		hm.put("2jelee", new Integer(90));
		hm.put("홍길동", new Integer(80));
		hm.put("가나다", new Integer(70));
		hm.put("플라밍고", new Integer(60));
		
//		System.out.println(hm); 	//결과 : {플라밍고=60, 홍길동=80, 가나다=70, 2jelee=90}
		Set set = hm.entrySet();	//entrySet : 싹다 가져온다.
		
		//interface인 iterator의 도움 필요
		Iterator iter = set.iterator();
		
		while (iter.hasNext()) {
//			iter.next();		//next: 가진거 다 나옴 >> 다음데이터를 가져오게 하므로
//			Map.Entry e = iter.next();		// error : 형변환 필요
			Map.Entry e = (Map.Entry)iter.next();	//형변환한 상태
			System.out.println("이름 : " +e.getKey()+" / 점수 : "+e.getValue());
		}
		
		set = hm.keySet();
		System.out.println("참가자 명단 : " + set);

		// Value값만 가져오기
		Collection values = hm.values();
		System.out.println(values);
		iter = values.iterator();
		
		int total = 0;
		while (iter.hasNext()) {
			Integer i = (Integer)iter.next();		// 작은 형으로 들어가니까 형변환
			total += i.intValue();
		}
		System.out.println("총합 : " + total);
		System.out.println("평균 : " + total / set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최하점수 : " + Collections.min(values));
	}
}
