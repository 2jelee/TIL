package etc_MAR.book;

import java.util.Arrays;
import java.util.Scanner;

class page123_StringBinarySearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] x = {
			"abstract", "assert", "boolean", "break", "byte",
			"instanceof", "int", "interface", "long", "native"
		};
		
		System.out.print("원하는 키워드 입력 : ");
		String key = sc.next();
		
		int idx = Arrays.binarySearch(x, key); //배열 x에서 값이 key인 요소 검색
		if(idx < 0) {
			System.out.println("해당 키워드 없음");
		} else {
			System.out.println("해당 키워드는 x["+idx+"]에 있다.");
		}
	}
}
