package ex07.Enum;

/*
 * enum 열거형 : 새로운 클래스 타입을 정의하는 것
 * - 특정한 값만을 가질 수 있는 데이터 타입을 정의할 때 필요함
 * 
 * 형식 :
 * [접근지정자] enum 열거형이름 {필요한 상수들 나열, ...}
 */

//접근지정자 생략 가능
enum UserStatus {
	PENDING,	//고유한 값 1번
	ACTIVIE,	// 			2번
	INACTIVE,	//			3번
	DELETE;		//			4번
}

/*
public interface MainEntry {
	public static void main(String[] args) {
		//1. 직접 호출
		System.out.println(UserStatus.ACTIVIE);
		System.out.println("----------------------------");
		
		//2. foreach 구문으로 호출해오기	>> 여기서 타입은 UserStatus 타입임
		for (UserStatus status : UserStatus.values()) {		// .values() : -s 붙은 것들은 대부분 배열타입이라고 생각하자
			System.out.println(status);
		}
		
		
//		switch (day) {
//		case SUNDAY:
//			
//			break;
//
//		default:
//			break;
//		}
	}
}
*/

enum Day { SUNDAY, MONDAY, TUESDAY; }


public class MainEntry {
		
	Day day; //열거형 변수 선언

	//3. 열거형 변수를 타입으로 만들 수 있음
	public MainEntry(Day day) {
		this.day = day;
	}
	
	public void tells() {
		switch (day) {
		case SUNDAY: 
			break;
		case MONDAY: 
			break;
		default:
			break;
		}
	}
}
	

