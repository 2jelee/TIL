package ex02.lambda;

@FunctionalInterface
interface Plus {	//functional interface
	int sum(int x, int y);
}

public class LambdaAnnotation {
	public static void main(String[] args) {
		//interface Plus를 가져와서 Lambda로 바꾸기
		Plus plus = (x, y) -> x + y;
		System.out.println(plus.sum(3, 5));
	}
}
