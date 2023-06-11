package etc_April;

import java.util.*;
import java.io.*;
 
public class JEL_10799 { 
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input  = br.readLine();
        int line = input.length();
        int result = 0;
 
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < line; i++) {
            char value = input.charAt(i);
            if (value == '(') stack.push(value);
            else {
                stack.pop(); 
                if (input.charAt(i-1) == '(') {
                	result += stack.size();
                } else { result++; }
            }
        }
        System.out.println(result);
    }
}
