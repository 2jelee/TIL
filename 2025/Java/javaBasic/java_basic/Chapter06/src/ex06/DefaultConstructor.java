package ex06;

class Data_1{
	int value;
}

class Data_2{
	int value; //인스턴스 변수 (=> static 없다!)
	
	//생성자(constructor)
	Data_2(int x){
		value = x; //인스턴스 변수 초기화
	}
}

public class DefaultConstructor {
	public static void main(String[] args) {
		Data_1 d1 = new Data_1();
		Data_2 d2 = new Data_2(); //compile error
		// Data_2 -> 컴파일 오류 발생
		/*
		[오류 내용]
		Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
			The constructor Data_2() is undefined
		
			at ex06.Constructor.main(Constructor.java:19)
			
		>> Data_2 클래스에 생성자 Data_2() 가 정의되어 있지 않아서 발생
		
		>> Data_1 클래스에는 생성자가 없어서 컴파일러가 자동적으로 기본 생성자를 추가해 주었다.
			컴파일러가 자동적으로 기본 생성자를 추가해주는 경우 : 클래스 내에 생성자가 하나도 없을 때 뿐이다.
		*/
	}
}
