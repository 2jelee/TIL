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
		
	}
}
