package ex05;

public class ArraysString {
	public static void main(String[] args) {
		String[] names = {"LEE", "KIM", "PARK"};
		
		for (int i = 0; i < names.length; i++) {
			System.out.println("names["+i+"] : " +names[i]);
		}
		
		String temp = names[2];
		System.out.println("temp : " + temp);
		names[0] = "Yu"; //배열의 첫번째 요소를 Yu로 변경
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}
}
