package ex06;

/*
 * 정의된 메서드를 작성하고 테스트 하시오.
 * 
 * 메소드명 : isNumber
 * 기능 : 주어진 문자열이 모두 숫자로만 이루어져 있는지 확인한다.
 * 		  모두 숫자로만 이루어져 있으면 true를 반환, 그렇지 않으면 false를 반환
 * 		  만일 주어진 문자열이 null이거나 빈 문자열 "" 이라면 false 반환
 * 반환타입 : boolean
 * 매개변수 : String str - 검사할 문자열 
 * 
 * ****************************
 * [결과]
 * 123은 숫자입니까? true
 * 1234o은 숫자입니까? false
 * 
 * *** String 클래스의 charAt(int i) 메서드를 사용하면 문자열의 i번째 위치한 문자를 얻을 수 있다.
 */

public class Practice18 {
	// isNumber 메서드를 작성
	/*
	boolean isNumber(String str) {
		//문자열의 i번째 위치 << 배열로 처리해야하지 않을까?
		if(str.charAt(0)==""|| str.charAt(0)=null) {
			return ;
		}
	}
	*/
	static boolean isNumber(String str) {
		if(str==null || str.equals("")) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch < '0' || ch > '9') {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " +isNumber(str));
	}
}
