package ex06;

/*
 * 실행결과를 예측하시오.
 * 
 * String 참조형인데 왜 변경되지 않을까?
 * change는 static >> 메모리 중 method 영역
 * 
문자열은 내용을 변경할 수 없기 때문에, 
덧셈연산을 하면 새로운 문자열이 생성되고 새로운 문자열의 주소가 변수 str에 저장된다.

이제 change메서드는 종료되고, 작업에 사용하던 메모리를 반환하므로 change메서드의 지역변수인 str역시 메모리에서 제거된다. 
다시 main메서드로 돌아와서 문자열 str의 값을 출력하면 처음의 값과 변함없는 값이 출력된다. 
문자열 "ABC123456"은 참조하는 변수가 하나도 없으므로 적절한 시기에 가비지컬렉터(garbage collector)에 의해 제거된다.
*/

class Practice16 {
	public static void change(String str) {
		str += "456";
	}
	
	public static void main(String[] args) {
		String str = "ABC123"; 
		System.out.println(str);
		change(str);
		System.out.println("After change : " +str);
	}
}
