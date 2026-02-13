package ex02.overload;

public class MainEntry {
	public static void line() {
		System.out.println("---------------------");
	}
	
	public static void line(String str, int n) {	
		for(int i=0; i <= n; i++) {
			System.out.print(str+ " ");
		}
	}
	
	/*
	public static void line(int x, int n) {
		for(int i=x; i<=n; i++) {
			System.out.print("+");
		}
		System.out.println();
	}
	*/

	public static void line(int x, int n) {
		/*
		if(x>n) {
			int t = x;
			x = n;
			n = t;
		}
		*/
		
		//삼항연산을 이용하여 바꿔치기(temp)
		int temp;
		temp = (x > n) ? x : n ;
		
		for(int i=n; i<=temp; i++) {	//for(int i=x; i<=n; i++) {
			System.out.print("&");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		line();	//static void	,	매개변수 X
		line(3);
		line("*", 10);
		
		line(3, 5);
		line(); //구분
		line(5, 3);		//문제 소지 있음. 해결할 것! 	해결 >> if문이나 삼항연산자로
		line();
		
		line(-30);		//문제 소지 있음.
	}
	
	public static void line(int n) {	//1) 함수명은 같으나, 매개변수 갯수는 다름	
		for(int i=0; i <= n; i++) {
			System.out.println("=====================");
		}
	}
}
