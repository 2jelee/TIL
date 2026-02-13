package ex02.lambda;

import java.util.ArrayList;
import java.util.List;

public class MainEntry {
	public static void main(String[] args) {
		//(매개변수 목록) -> { 실행문 }
		Thread t = new Thread(()->{
			System.out.println("Thread Start");
			
			try {
				//예외발생 : interruptedException
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread END");
		});	
		
//		t.start();
//		System.out.println(t);		//중간값 5 //숫자가 작을수록 우선순위 높다.		//출력 : Thread[Thread-0,5,main]	<< main : getName??
//		System.out.println(t.getName()+ t.getPriority()); 
		
		System.out.println("----------------------------");
		//List는 interface이므로 자체적으로 객체 생성 X하므로 new ArrayList() 했다.
		List<String> list = new ArrayList();
		
		list.add("java");
		list.add("jsp");
		list.add("Spring");
		list.add("React");
		
//		System.out.println(list);				//출력방법 1
//		for (int i = 0; i < list.size(); i++) { //출력방법 2
//			System.out.println(list.get(i));
//		}
		
		//Lambda로 출력하기	>> forEach문
		//매개변수 1개일 경우 () 생략 가능
		//한 줄 실행시 { } _실행문도 생략 가능
//		list.forEach((item) -> { System.out.println(item); });
		list.forEach(item -> System.out.println(item));	//출력방법 3
	}
	
}
