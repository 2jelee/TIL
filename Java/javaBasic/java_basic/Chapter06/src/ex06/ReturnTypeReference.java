package ex06;

class Data3 {
	int x;
}

public class ReturnTypeReference {
	public static void main(String[] args) {
		Data3 d = new Data3();
		d.x = 10;
		
		Data3 d2 = copy(d);
		System.out.println("d.x = "+ d.x);
		System.out.println("d2.x = "+ d2.x);
	}
	
	//반환 타입이 void가 아니다, Data3이다.
	static Data3 copy(Data3 d) {
		Data3 temp = new Data3();
		
		temp.x = d.x;
		
		return temp;
	}
}
