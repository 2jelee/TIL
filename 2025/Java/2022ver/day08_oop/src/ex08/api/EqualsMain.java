package ex08.api;

class Circle {
	int x, y;
	
}

public interface EqualsMain {
	public static void main(String[] args) {
		
		// ※이들은 서로 주소 다름!※
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		
		System.out.println("c1의 주소 : "+ c1.hashCode());
		System.out.println("c2의 주소 : "+ c2.hashCode());
		
		int x=3, y=3;
		System.out.print("기본 자료형 비교하기 : ");
		if(x==y) System.out.println("같다");			// == 은 실제 값을 비교하는 것
		else System.out.println("다르다");

		/****************************************************************/
		
		
		System.out.print("참조자료형(Refference type) 비교하기 : ");
		String str1 = new String("KOSA");
//		String str2 = new String("KOSA");
		String str2 = new String("kosa");
		
		// "KOSA"를 비교하는 것이 X 	>> str끼리의 주소 비교하는 것임
		if(str1==str2) System.out.println("참조자료형 같다.");
		else System.out.println("참조자료형 다르다");
		
		System.out.println("***** equals() method 비교 *****");
		//Heap 영역에 있는 내용을 비교하겠다.							// eqauls는 대소문자 구분한다! 그러므로 KOSA 하나가 kosa면 다르게 뜸
		if(str1.equals(str2)) System.out.println("같다");
		else System.out.println("다르다");
		
		System.out.println("***** equalsIgnoreCase() method 비교 *****");
		if(str1.equalsIgnoreCase(str2)) System.out.println("같다"); //eqaulsIgnoreCase는 대소문자 구분하지 않는다!!
		else System.out.println("다르다");
		
		
	}
}
