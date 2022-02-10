package ex03.utilPackage;

import java.util.StringTokenizer;

/*
 * [StringTokenizer]
 * split과 유사
 */

public class StringTokenizerMain {
	public static void main(String[] args) {
		/*
		StringTokenizer token = new StringTokenizer("2 j e l e e");
		
		//구분자로 끊어서 출력
		while (token.hasMoreTokens()) {
			System.out.println(token.nextToken());
		}
		*/
		
		StringTokenizer token = new StringTokenizer("사과=10|초콜릿=3|샴페인=1", "=|", true);
		
		String str = token.nextToken();
		if(str.equals("=")) System.out.print("\t");
		else if (str.equals("|")) System.out.println();
		else System.out.println(str);
	}
}
