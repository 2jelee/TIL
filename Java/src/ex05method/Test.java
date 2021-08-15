package ex05method;

import java.util.Scanner;

public class Test {
	 public static void main(String[] args) {
	      Scanner scanner = new Scanner(System.in);
	      
	      System.out.print("시작값:");
	      int s = scanner.nextInt();
	      System.out.print("종료값:");
	      int e = scanner.nextInt();
	      yesParamNoReturn(s, e);
	   }
	   
	   /*
	   1에서 10까지의 합을 구하는 프로그램의 시작과 종료값만 변수로
	   변경하여, 원하는 구간의 합을 구하는 프로그램으로 커스트마이징 하였다.
	    */
	   static void yesParamNoReturn(int startNum, int endNum) {
	      
	      int sum = 0;
	      for(int i=startNum ; i<=endNum ; i++) {
	         sum +=1;
	      }
	      //계산의 결과를 즉시 출력한다.
	      System.out.printf("%d~%d까지의합은:%d",
	            startNum, endNum, sum);
	      

	   }
}
