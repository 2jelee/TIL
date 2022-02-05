package ex07.randomClass;
/*
[문제] Random class - java.util.package
		nextXXX();
			자료형
		nextInt();
		nextDouble();
		nextFloat(), ...
		
		rand.nextInt(n); //0 ~ n-1값 추출함
 */

import java.util.Random;	//해당 패키지는 util. lang패키지 말고는 모두 import 필수

public class RandomClass {
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(rand.nextInt());		//nextInt() int형 크기 안에 있는 임의의 숫자 추출됨
		System.out.println(rand.nextInt(5)); //0~4
		System.out.println(rand.nextInt(10)+1); //1~10
		
		System.out.println();
		for(int i=1; i<7; i++) {
//			System.out.println((Math.random()*45)+1);	 
			System.out.print(rand.nextInt(45)+1+" ");	//1~45까지의 수
		}
	}
}
