package ex02.operator;

//최단산쉬관논삼대콤
 
public class MainEntry {
	public static void main(String[] args) {
		//관계연산자 : >, <, >=, <=, ==(같다), !=(같지않다)
		int x=2, y=20;
		
		if(x != y) {
			System.out.println("같지않다.");
		} else {
			System.out.println("같다.");
		}
		
		//삼항연산자 : (조건)? 참 : 거짓 ;
		String msg = null; //초기화 시켜줌. 이는 msg="";와 같음.
		msg = (x!=y) ? "같지 않습니다." : "같습니다.";
		System.out.println("msg 출력 : " + msg);
		
		int a = 10, b = 20, c = 30, result;
		
		result = (a > b) ? a : b;
		result = (a > b) ? a : (b > c) ? b : c;		//중첩도 가능하다.
	}
}
