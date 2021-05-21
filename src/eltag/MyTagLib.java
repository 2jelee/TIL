package eltag;

public class MyTagLib {
	/*
	매개변수로 문자열을 받은 후 문자배열로 만들어서
	문자열에 숫자가 아닌 문자가 포함되었는지 판단하는 메소드.
	문자열 전체가 숫자인 경우 true를 반환함.
	 */
	public static boolean isNumber(String value) {
		//toCharArray()는 문자열을 문자배열로 반환해줌
		char[] chArr = value.toCharArray();
		for(int i=0; i<chArr.length; i++) {
			
			if(!(chArr[i]>='0' && chArr[i]<='9')) { //각 문자의 아스키코드를 검사
				return false; //숫자형이 아니라면 false를 반환
			}
		}
		return true; //전체가 숫자이면 true를 반환
	}
}
