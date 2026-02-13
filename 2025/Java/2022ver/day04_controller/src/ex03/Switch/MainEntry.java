package ex03.Switch;

import java.util.Scanner;

/*
[switch문]
if문의 조건값은 boolean형임에 비해
switch문의 조건값은 long형을 제외한 정수형(byte, short, int) 또는 char형인 것이 다름.

장점 : 가독성 ↑

switch(argument value_식_정수형만 가능하다!){
	case 조건값1 :		<< colon (:)    	| 수행문은 중복 가능
		수행문; 
		break;			<< 안써야하는 상황도 생긴다 : 누적하는 경우
	case 조건값2 :
		수행문; 
		break;			
	case 조건값3 :
		수행문; 
		break;
	default : 		<< 생략 가능
		수행문;	
		break;
	}

>> 숫자, '문자', "문자열"만 가능.
	즉, 실수형 X
	

"자동완성"
switch (key) {
	case value:
		break;

	default:
		break;
	}
*/
public class MainEntry {
	public static void main(String[] args) {
		
		System.out.print("당신의 point는 ? ");
		int point = new Scanner(System.in).nextInt();
		
		switch (point) {	//조건 - 문자형, 정수형(long형 제외_너무 숫자가 크므로) 가능 | 실수형 X
			case 1:
				System.out.println("포인트 점수 1점입니다.");
				break;
			case 2:
				System.out.println("포인트 점수 2점입니다.");
				break;
			case 3:
				System.out.println("포인트 점수 3점입니다.");
				break;
	
			default:		//생략하지 않는 것이 좋다!
				System.out.println("없는 점수입니다. ※1~3까지 입력 요망※");
				//break;
		} //end of switch 
		// console에 문자열을 입력할 경우 Exception이 나오는데, 이는 try~catch로 막으면 된다.
		
	}
}
