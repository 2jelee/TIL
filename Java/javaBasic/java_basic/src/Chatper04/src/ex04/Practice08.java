package ex04;

/*
 * Math.random()을 이용해서 1 ~ 6사이의 임의의 정수를 변수 value에 저장하는 코드를 완성하라
 */

public class Practice08 {
	public static void main(String[] args) {
		int value = (int)(Math.random()*6)+1;
		System.out.println("value : " +value);
	}
}
