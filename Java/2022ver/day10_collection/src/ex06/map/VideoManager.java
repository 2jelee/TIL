package ex06.map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class VideoManager extends Video {	//controller
	
	static HashMap<String, Video> map = new HashMap<String, Video>();
	static int top =1;
	
	public static void modify() {
		System.out.print("변경하실 비디오 제목을 입력해주세요 : ");
		String title = scan.next();
		String category = map.get(title).category;
		
		if(map.containsKey(title)) {
			map.put(title, new Video(title, category));
			System.out.println("변경되었습니다.");
		} else {
			System.out.println("비디오 제목을 잘못 입력하셨습니다. 해당 정보가 없습니다.");
		}
	}
	
	public static void delete() {
		System.out.println("삭제하실 비디오 제목을 입력해주세요 : ");
		String title = scan.next();
		if(map.containsKey(title)) {
			map.remove(title);
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("비디오 제목을 잘못 입력했습니다. 해당 정보가 없습니다.");
		}
	}

	public static void print() {
		System.out.println("보유하고 있는 비디오 갯수 : " + top);
		System.out.println("비디오제목 --- 장르 --- 대여정보 --- 대여자 --- 대여일자");
		Set<String> set = map.keySet();
		for (String video : set) {
			String title = map.get(video).title;
			String category = map.get(video).category;
			String lend = map.get(video).lend;
			
			if(lend.equalsIgnoreCase("y")) {
				lend = "대여";
			} else {
				lend = "대여 안함";
			}
			
			String lendName = map.get(video).lendName;
			if(lendName == null) {
				lendName = "정보 없음";
			}
			String lendDate = map.get(video).lendDate;
			if(lendDate == null) {
				lendDate = " 정보 없음";
			}
			System.out.println(title + "\t" + category + "\t" + lend + "\t" +lendName + "\t" + lendDate);
		}
	}
	
	public static void insert() {
		System.out.print("비디오 제목을 입력하세요 : ");
		String title = scan.next();
		System.out.print("장르를 입력하세요 : ");
		String category = scan.next();
		map.put(title, new Video(title, category));
		top++;
	}
}
