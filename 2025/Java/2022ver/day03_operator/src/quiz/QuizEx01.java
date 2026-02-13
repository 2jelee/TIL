package quiz;

public class QuizEx01 {
	public static void main(String[] args) {
		// %, / 산술연산자 이용한 계산결과 출력하기
		int pay = 567890, result, man, chun, baek, sip; //567,890원
		int m_na, chun_na, baek_na, sip_na;
		
		m_na = pay/10000;
		System.out.println("만원:"+m_na+"장");
		chun_na = (pay%10000)/1000;
		System.out.println("천원:"+chun_na+"장");
		baek_na = ((pay%10000)/100)%10;
		System.out.println("백원:"+baek_na+"개");
		sip_na = ((pay%10000)/10)%10;
		System.out.println("십원:"+sip_na+"개");
		
		
		//결과 : 만원이 56장 | 천원 : 7장 | 백원 :8개 | 십원:9개 
		
		
//		========================================================
		//1. 변수선언
		int pay2 = 567890;
		int man2, chun2, back2, sip2; //몫 저장변수
		int m_na2, ch_na2, b_na2;	  //나머지 저장변수
		
		//2. 메세지 출력 및 입력받기
		//3. 처리(계산)
		man2 = pay2 / 10000;		m_na2 = pay2 % 10000;
		chun2 = pay2 / 1000;		ch_na2 = pay2 % 1000;
		back2 = pay2 / 100; 		b_na2 = pay2 % 100;
		sip2 = pay2 / 10;			sip2 = pay2 % 10;
		
		//4. 결과출력(화면)
		System.out.println("\n\n 만원 : " + man2
						   + "장\n천원 : " + chun2
						   + "개\n백원 : " + back2
						   + "개\n십원 : " + chun2
						   );	
	}
}
