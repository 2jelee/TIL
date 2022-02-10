package ex03.utilPackage;

import java.util.Calendar;
import java.util.Date;

public class MainEntry {
	public static void main(String[] args) {
		// Calendar => new 사용 X
		Calendar c = Calendar.getInstance();		//system이 가지고 있는 날짜를 얻어온다.
		
		System.out.print(c.get(Calendar.YEAR) + "년");		//1부터 시작
//		System.out.print(c.get(Calendar.MONTH) + "월");		//0부터 시작 ★★★★★★★
		System.out.print(c.get(Calendar.MONTH)+1 + "월");	//0부터 시작 ★★★★★★★
		System.out.print(c.get(Calendar.DATE) + "일");		//1부터 시작
		
		System.out.println("\n==============================\n");
	
		Date date = new Date();
		int h = date.getHours();
		int m = date.getMinutes();
		int s = date.getSeconds();
		
		System.out.println("현재 시간은 " + h + ":" + m + ":" + s);
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		
		//0, 0, 0, >> 시 분 초
		c2.set(2022, 2, 9, 0, 0, 0);
		
		if(c1.after(c2)) {			//이후를 비교
			System.out.println("현재 시간은 2022년 1월 1일 이후입니다.");
		} 
		else if (c1.before(c2)) {	//이전을 비교
			System.out.println("현재 시간은 2022년 1월 1일 이전입니다.");			
		}
		else if(c1.equals(c2)) {	//같은지 비교
			System.out.println("현재 시간은 2022년 1월 1일입니다.");						
		}
	}
}
