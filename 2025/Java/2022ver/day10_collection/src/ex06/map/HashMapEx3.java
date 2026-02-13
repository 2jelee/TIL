package ex06.map;

import java.util.*;

class HashMapEx3 {
	static HashMap phoneBook = new HashMap();

	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-2222");
		addPhoneNo("친구", "김자바", "010-333-3333");
		addPhoneNo("회사", "김대리", "010-444-4444");
		addPhoneNo("회사", "김대리", "010-555-5555");
		addPhoneNo("회사", "박대리", "010-666-6666");
		addPhoneNo("회사", "이과장", "010-777-7777");
		addPhoneNo("세탁", "010-888-8888");

		//출력하고자하는 사용자 메소드
		printList();
	} // main

	// 그룹을 추가하는 메서드
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName))		//key값으로 구분하므로
			phoneBook.put(groupName, new HashMap());
//							 K 				V			>> 여기서 Value에 새로 또 만드는..
	}

	// 그룹에 전화번호를 추가하는 메서드
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap)phoneBook.get(groupName);
		group.put(tel, name);	// 이름은 중복될 수 있으니 전화번호를 key로 저장한다.
	}

	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}

	// 전화번호부 전체를 출력하는 메서드
	static void printList() {
//		Set set = phoneBook.entrySet();
//		Iterator it = set.iterator();	
		Iterator it = phoneBook.entrySet().iterator();	//위 두줄 합쳐서 이처럼 할 수 있다.
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();

			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();	

			System.out.println(" * "+e.getKey()+"["+subSet.size()+"]");

			//이 데이터가 있는 수만큼 출력하겠다.
			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next();
				String telNo = (String)subE.getKey();
				String name = (String)subE.getValue();
				System.out.println(name + " " + telNo );
			}
			System.out.println();
		}
	}	// printList()
} // class