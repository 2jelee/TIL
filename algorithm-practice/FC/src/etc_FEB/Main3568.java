package etc_FEB;

/*
[풀이방법]
1) 먼저 입력값을 StringTokeniger로 자름

2) boolean형 변수를 활용해 맨처음 부분만 type 변수에 따로 저장한다.

3) 다음 토큰부터 한번 더 boolean형 변수를 활용해  특수문자가 나올때까지 끊어준다. 변수명 val 변수에 저장.

4) 이제 남은 문자열은 스택에 저장하는데 괄호부분은 반대로 넣어야하며 세미콜론은 넣지 않는다.

5) StringBuffer에 type + 스택의 내용 + 공백 + val + 세미콜론을 넣고 출력한다. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3568 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		boolean typeIsSelected = false;
		tokens = new StringTokenizer(input.readLine());
		String type = "";
		while(tokens.hasMoreTokens()) {
			if(!typeIsSelected) {
				type = tokens.nextToken();
				typeIsSelected = true;
			}
			
			String str = tokens.nextToken();
			boolean valIsSelected = false;
			int valend = str.length()-1;
			for(int i=0; i<str.length(); i++) {
				if(!valIsSelected) {
					if(str.charAt(i)== '&' || str.charAt(i)== '*' || str.charAt(i)== '[' || str.charAt(i)== ']') {
						valend = i;
						valIsSelected = true;
					}
				}
			}
			String val = str.substring(0,valend);
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)== '&' || str.charAt(i)== '*') {
					stack.add(str.charAt(i));
				} else if(str.charAt(i)== '[') {
					stack.add(']');
				} else if(str.charAt(i)== ']') {
					stack.add('[');
				}
			}
			StringBuffer sb = new StringBuffer();
			sb.append(type);
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.append(" ");
			sb.append(val);
			sb.append(';');
			
			System.out.println(sb);
		}
	}
	static String src = "int& a*[]&, b, c*;"; 
}
