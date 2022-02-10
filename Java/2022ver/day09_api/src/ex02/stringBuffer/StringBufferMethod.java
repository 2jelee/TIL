package ex02.stringBuffer;

public class StringBufferMethod {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This");
		System.out.println(sb);
		
		sb.append(" is pencil"); // append : 문자열 추가 << 무조건 뒤에
		System.out.println(sb);
		
		//7번 위치에				원하는 위치 찾기 : indexOf
		sb.insert(7, " my");	//특정 위치에 문자열 삽입
		System.out.println(sb);
		
		//문자열을 변경(교체)하고 싶을 경우
		sb.replace(8, 10, "your");	// 시작값 8.	10은 미포함(앞_mainEntry에서 했던 것과 같이)
		System.out.println(sb);
		
		System.out.println(sb.length());
		sb.setLength(5);
		System.out.println(sb);
		System.out.println(sb.capacity());
		
		//20정도의 크기로 setting
		sb.setLength(20);
		System.out.println(sb);	// 결과 : This		>> 크기를 줄임으로써 뒤 문자들 사라짐을 확인
		
		//역방향으로 출력하기 (글자를 뒤집어서)
		System.out.println(sb.reverse());
	}
}
