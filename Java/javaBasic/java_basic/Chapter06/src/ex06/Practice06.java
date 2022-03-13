package ex06;

/*
 * Practice04에서 작성한 클래스 메서드 getDistance()를 MyPoint 클래스의 인스턴스메서드로 정의하시오.
 */

class MyPoint{
	int x;
	int y;
	
	//생성자
	MyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	//인스턴스 메서드 getDistance를 작성하시오.
	double getDistance(int x1, int y1) { //인스턴스 메서드
		return Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));  //x, y는 지역변수
	}
}


class Practice06 {
	public static void main(String[] args) {
		MyPoint p = new MyPoint(1, 1);
		
		// p와 (2, 2)의 거리를 구한다.
		System.out.println(p.getDistance(2, 2));
	}
}
