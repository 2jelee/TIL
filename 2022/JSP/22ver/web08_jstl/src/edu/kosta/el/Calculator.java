package edu.kosta.el;

public class Calculator {
	// 태그라이브러리 이용시 함수에 반드시 static 키워드 붙여줘야함
	public static int add(String x, String y) {
		int su1=0, su2=0;
		
		try {
			su1 = Integer.parseInt(x);
			su2 = Integer.parseInt(y);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ( su1 + su2 );
	}
}
