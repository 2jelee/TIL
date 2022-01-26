package quiz;

public class QuizEx02 {
	public static void main(String[] args) {
		
		int su = 123456;
//		시 : 분 : 초 		60초 =>1분		60분=>1시간			1시간은 3600초 1분은 60초
		int h, m, s;
		h = su/3600;		//122,400
		System.out.print(h+"시");
		m = (su%3600)/60;
		System.out.print(m+"분");
		s = (su%3600)%60;
		System.out.print(s+"초"); 
	}
}
