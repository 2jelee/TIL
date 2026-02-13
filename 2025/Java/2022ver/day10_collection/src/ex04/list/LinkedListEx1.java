package ex04.list;
import java.util.*;
class  LinkedListEx1{
	public static void main(String[] args) {
		LinkedList list = new LinkedList();				//타입을 지정하지 않은 경우
//		LinkedList<String> list = new LinkedList<String>();	// 타입을 지정한 경우
		
		list.add("c");
		list.add("d");
		list.add("k");
		list.add("o");
		list.add("p");
		list.add("x");
		list.addFirst("a");			//앞쪽으로 끼워라
		list.addLast("z");			//뒤쪽에 끼워라
		
		System.out.println(list);
		list.remove("k");
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.set(2,"a");
		System.out.println(list);
		list.set(3,list.get(1)+"change");
		System.out.println(list);
		String str1 = (String)list.peek();
		System.out.println("=====================");
		System.out.println(str1);
		System.out.println(list);
		String str2 = (String)list.poll();
		System.out.println(str2);
		System.out.println(list);
		list.offer("a");
		System.out.println(list);
		String str3 = (String)list.remove();
		System.out.println(str3);
		System.out.println(list);
	}
}
