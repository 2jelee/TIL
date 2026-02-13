package ex04.util;
import java.util.Date;
import java.text.SimpleDateFormat;

/*
Format 함수 ★★★
*/

class DateFormatEx1{
	public static void main(String[] args) {
		Date today = new Date();
		
		System.out.println(today);  //
		
		SimpleDateFormat sdf1, sdf4;
		
		sdf1 = new SimpleDateFormat("yy-MM-dd");					//무조건 소문자 : 연도, 일자	 | 		대문자 : 월
		
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a E");		// a: a.m./p.m.		E : 요일
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a EEEE");	// EEE : '요일'이 붙어서 나온다
		
		System.out.println(sdf1.format(today));	// format(Date d)
		System.out.println(sdf4.format(today));
	}
}