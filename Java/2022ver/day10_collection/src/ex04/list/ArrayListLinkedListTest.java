package ex04.list;

import java.util.*; 

public class ArrayListLinkedListTest { 
	public static void main(String args[]) { 
	  
        ArrayList al = new ArrayList(1000000);
        LinkedList ll = new LinkedList(); 
        
        System.out.println("= 순차적으로 추가하기 ="); 	//숫자를 하나하나 넣는
        System.out.println("ArrayList :"+add1(al)); 
        System.out.println("LinkedList :"+add1(ll)); 

        System.out.println(); 
        System.out.println("= 중간에 추가하기 ="); 
        System.out.println("ArrayList :"+add2(al)); 
        System.out.println("LinkedList :"+add2(ll)); 

        System.out.println(); 
        System.out.println("= 중간에서 삭제하기 ="); 
        System.out.println("ArrayList :"+remove2(al)); 
        System.out.println("LinkedList :"+remove2(ll)); 

        System.out.println(); 
        System.out.println("= 순차적으로 삭제하기 ="); 
        System.out.println("ArrayList :"+remove1(al)); 
        System.out.println("LinkedList :"+remove1(ll)); 
	}
	
	public static long add1(List list) { 
	    long start = System.currentTimeMillis(); //시작 시간
	
	    for(int i=0; i<100000;i++) 	//작업
			list.add(i+""); 
	
	    long end = System.currentTimeMillis(); //끝난 시간
	    return end - start; 
	} 

	public static long add2(List list) { 
	    long start = System.currentTimeMillis(); 
	    for(int i=0; i<1000;i++) 
			list.add(500, "X"); 			//중간에 데이터 넣기
	    
	    long end = System.currentTimeMillis(); 
	    return end - start; 
	} 

	public static long remove1(List list) { 
        long start = System.currentTimeMillis(); 
        for(int i=list.size()-1; i > 0; i--) //끝에서부터 지우므로 끝까지 다 지울 수 있음	>> 전체 지워짐
			list.remove(i); 
        
//        	list.removeAll(i);			//for문 없이 removeAll하면 다 지울 수 O	  >> 작업시간 체크를 위해 본 예제에서 for문을 사용
        
        long end = System.currentTimeMillis(); 
        return end - start; 
	} 

	public static long remove2(List list) { 
        long start = System.currentTimeMillis(); 
        for(int i=0; i<1000; i++) 				//처음부터 끝까지 다 지울 수 없음	>> 전체 지울 수 X
			list.remove(i); 
        long end = System.currentTimeMillis(); 
        return end - start; 
	} 
} 