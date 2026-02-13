package ex08.api;

class Rectangle{
	int x, y;
	public void disp() {
		System.out.println(x + ", " + y);
	}
	
	//[추가]
//	/*
	//주솟값이 아닌 실제 data 값을 가져오고 싶다!
	@Override
	public String toString() {
		return x+", "+y;		// <<여기 코드(return문) 생김새 확인해보자
	}
//	 */
	
	/*
	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + "]";
	} 
	*/
}

public interface ToStringMain {
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		r.disp();
		//위의 [추가] 코드가 없으면 주솟값으로 출력되게 된다!
		System.out.println(r);
		System.out.println(r.toString());	
	}
}
