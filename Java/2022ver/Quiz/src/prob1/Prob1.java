package prob1;
 
public class Prob1 {
	public static void main(String[] args) {
		int seconds = 47567;
		System.out.println("<< " + seconds + " 초 변환 시간 >>");
		System.out.println(printTime(seconds));
		
		seconds = 11578;
		System.out.println("<< " + seconds + " 초 변환 시간 >>");
		System.out.println(printTime(seconds));
	}

	private static int printTime(int seconds) {
		// 구현하세요.
//		int hour = 3600;
//		int minute = 60;
//		int second = 1;
		int hour = seconds/3600;
		int minute = seconds/60-(hour*60);
		int second = seconds%60;
//		int result = 0;
//		int result2 = 0;
		
//		hour = seconds/hour;
//		seconds = seconds%minute;
//		second = minute%minute;
		System.out.printf("%d시 %d분 %d초",hour,minute,second);
		return seconds;
	}
}