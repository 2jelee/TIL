package ex03.bufferedReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 사칙연산 프로그램 만들기 << IO 이용
 */

public class Quiz_calc {
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("계산할 숫자를 입력하시오. ");
		
		int su1, su2;
		String boho = "";
//		String s1 = br.readLine();		//예외 발생한다. 여러 개의 데이터 입력 받기
//		String s2 = br.readLine();
		
		//숫자 타입으로 parsing
		su1 = Integer.parseInt(br.readLine());
		su2 = Integer.parseInt(br.readLine()); 
		boho = br.readLine();
		if(boho == "+") {
			System.out.println(su1+su2);			
		}
		if(boho == "-") {
			System.out.println(su1-su2);			
		}
		if(boho == "*") {
			System.out.println(su1*su2);			
		}
		if(boho == "/") {
			System.out.println(su1/su2);			
		}
//		
//		String str = br.readLine(); //예외발생		>> 1. try~catch		 2. 위임 throws Exception
//		System.out.println(str);
	}
}
