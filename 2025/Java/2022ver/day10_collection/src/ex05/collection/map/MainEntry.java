package ex05.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Map map = new HashMap();
		
		map.put("KOSA", "th2");
		map.put("KBS", 07);
		map.put("IT", "12345");
		map.put("KOSA", "th2");
		
		//요소 수 세기
		System.out.println("요소의 갯수 : "+map.size()+"개");	//key값이 중복되면 덮어쓴다.	결과 : 3
		Scanner sc = new Scanner(System.in);
		
		//무한루프
		while (true) {
			System.out.println("ID와 PW를 입력해주세요.");
			System.out.print("ID : ");
			String id = sc.nextLine().trim();		//trim으로 공백제거
			System.out.print("PW : ");
			String pw = sc.nextLine().trim();
			
			// containsKey => 추상메소드
			if(!map.containsKey(id)) {
				System.out.println("해당 아이디는 존재하지 않습니다.");
				System.out.println("다시 입력해주세요");
				continue;		
				/*
				 * 정의 : 반복문 내에서만 사용되며, 반복이 진행되는 도중 continue문을 만나면 반복문의 끝으로 이동하여 다음 반복문으로 넘어간다. 
				 * ex )  for 문의 경우 증감식으로 이동, while문의 경우 조건식으로
				 */ 
			} else {
				if(!map.get(id).equals(pw)) {
					System.out.println("비밀번호가 일치하지 않습니다. 재입력하세요.");
				} else System.out.println("비밀번호가 일치합니다. / 해당 ID : " + id);
					break;		//빠져나가기
			}
			
		}
	}
}
