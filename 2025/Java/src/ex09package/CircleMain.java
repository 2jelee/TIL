package ex09package;

import ex09package.kosmo.perimeter.Circle;

public class CircleMain {

	public static void main(String[] args) {
		
		//원의 넓이 : 클래스 사용을 위해 풀 패키지 경로를 사용한다. 
		ex09package.kosmo.area.Circle circle1 = 
				new ex09package.kosmo.area.Circle(6.5);
		System.out.println("반지름이 6.5인 원의넓이:"
				+ circle1.getArea());
		
		//원의 둘레 : import하여 해당 클래스를 문서에 포함한다. 
		Circle circle2 = new Circle(4.5);
		System.out.println("반지름이 4.5인 원의둘레:"
				+ circle2.getPerimeter());
		
	}

}
