package ex01.collection.set;

import java.util.HashSet;
import java.util.Set;

class Person {		// = class Person extens Object		(defalt다.)
	//멤버필드
	String name;
	int age;
	
	//멤버필드를 가지는 생성자함수
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
//		return "Person [name=" + name + ", age=" + age + "]";
		return "[name=" + name + ", age=" + age + "]\n";
	}

	@Override
	public boolean equals(Object obj) {
//		return super.equals(obj);

		//Person을 obj로 만들 수 있는가
		if(obj instanceof Person) {
			// YES
			Person temp = (Person)obj;	//작은쪽으로 형변환
			return name.equals(temp.name) && age == temp.age;
		}
		// NO
		return false;
	}
	

	@Override
	public int hashCode() {
//		return super.hashCode();
		return name.hashCode() + age;
	}
}

public class HashSetMain {
	public static void main(String[] args) {
		//set 타입의 instance 생성
		Set set = new HashSet();
		
		set.add(new Person("2jelee", 26));
		set.add(new Person("2jelee", 27));
		set.add(new Person("2jelee", 28));
		set.add(new Person("2jelee", 26));
		
		set.add(new String("플라밍고"));
		set.add(new String("분홍색"));
		set.add(new String("플라밍고"));
		
		System.out.println(set);
	}
}
