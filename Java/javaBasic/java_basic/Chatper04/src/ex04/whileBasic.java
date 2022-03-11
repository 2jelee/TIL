package ex04;

/*
 * i-- : 후위감소이므로 조건식이 평가된 후 i값이 감소
 * 즉, 5~1이 아니라 4~0으로 출력됨
 * 
 */
public class whileBasic {
	public static void main(String[] args) {
		int i = 5;
		
		while(i--!=0) {
			System.out.println("i값 : "+i+" => We Can Do it!");
		}
	}
}
