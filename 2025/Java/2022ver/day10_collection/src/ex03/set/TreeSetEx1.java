package ex03.set;
import java.util.*;
class TreeSetEx1 {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();	// TreeSet : 출력 시 정렬되어 나온다.(자동 정렬)
										// 우선순위 : 숫자 > 영문자(1.대문자 2.소문자) > 한글
										// set은 원래 순서 X
		String from = "a";
		String to	= "b";
		
		set.add("abc");
		set.add("alien");set.add("bat");
		set.add("car");set.add("Car");
		set.add("disc");set.add("dance");
		set.add("dZZZZ");set.add("dzzzz");
		set.add("elephant");set.add("elevator");
		set.add("fan");set.add("flower");
		
		System.out.println(set);
		System.out.println("range search : from " + from  +" to "+ to);	// from : 포함 | to : 미포함
		System.out.println("result1 : " + set.subSet(from, to));		 
		System.out.println("result2 : " + set.subSet(from, to + "zzz"));	//b가 포함되서 들어간다
	}
}