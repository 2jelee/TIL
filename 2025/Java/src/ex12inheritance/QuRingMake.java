package ex12inheritance;
/*
문제4) QuRingMake.java
다음 Point클래스를 이용하여 다음 문제를 해결하시오. 해당 문제는 상속을 통해 
구현하는것이 아니라 구성관계를 이용하여 해결한다. Point 클래스를 기반으로 
원을 의미하는 Circle클래스를 정의하자. 그리고 Circle클래스를 기반으로 
Ring클래스를 정의하자.
 */
class Point
{
   	int xDot, yDot;
   	public Point(int x, int y){
        xDot=x;
        yDot=y;
   	}
   	public void showPointInfo()
   	{
        System.out.println("[x좌표:"+xDot+", y좌표"+yDot+"]");
   	}
}

//Point클래스를 기반으로 원(Circle) 클래스 표현하기
class Circle{	
	//멤버변수
	int radian;//반지름
	Point center;
	//생성자
	public Circle(int x, int y, int r) {
		radian = r;//반지름 초기화
		center = new Point(x, y);//중심점을 표현하는 객체
	}
	//원의 정보를 출력하는 멤버메소드
	public void showCircleInfo() {
		/*
		반지름은 멤버변수를 통해 즉시 출력하고, 중심점은 Point객체의 
		멤버메소드를 호출하여 출력한다. 
		 */
		System.out.println("반지름:"+radian);
		center.showPointInfo();
	}
}

//원 2개를 겹쳐서 링을 표현하는 클래스
class Ring{
	//멤버변수
	Circle innerCircle;//안쪽의 원
	Circle outerCircle;//바깥쪽의 원
	//생성자
	/*
	링 클래스에서는 원이 2개 있어야 하므로 아래와같이
	Circle객체를 2개 생성한다. 
	 */
	public Ring(int inX, int inY, int inR, int outX, int outY, int outR) {
		//멤버변수가 객체이므로 해당 객체를 생성해야한다.
		innerCircle = new Circle(inX, inY, inR);//중심점(x, y), 반지름(r)
		outerCircle = new Circle(outX, outY, outR);
	}
	//링을 표현하는 멤버메소드
	public void showRingInfo() {
		/*
		상속관계가 아니므로 각각의 멤버변수(Circle객체)를 통해 
		멤버메소드를 호출해야 한다. 
		 */
		System.out.println("안쪽원의정보:");
		innerCircle.showCircleInfo();
		System.out.println("바깥쪽원의정보:");
		outerCircle.showCircleInfo();
	}
}
class QuRingMake {
	public static void main(String[] args) {
		Ring c = new Ring(1,1,3,2,2,9);
		c.showRingInfo();
	}
}
