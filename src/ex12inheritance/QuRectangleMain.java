package ex12inheritance;
/*
문제3) QuRectangleMain.java
정사각형을 의미하는 Square클래스와 직사각형을 의미하는 Rectangle클래스를 정의하고자 한다.
그런데 정사각형은 직사각형의 일종이므로, 다음의 형태로 클래스의 상속관계를 구성하고자 한다. 
아래의 소스를 참조하여 구현하시오. 
 */

//직사각형을 표현한 클래스
class Rectangle
{
    //멤버변수
	int width;//가로 길이
	int height;//세로 길이
	//생성자
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	//직사각형의 넓이를 출력
	public void ShowAreaInfo() {
		System.out.println("직사각형넓이:"+ (width*height));
	}
} 
//정사각형을 표현한 클래스(정사각형은 직사각형의 일종)
class Square extends Rectangle
{
	/*
	멤버변수
	 : 해당 클래스의 경우는 부모클래스가 이미 가로, 세로에 대한
	 멤버변수를 정의하였으므로 자식쪽에서는 멤버변수의 확장은 필요없다. 	
	 */
	/*
	자식의 생성자 : 정사각형은 가로, 세로의 길이가 동일하므로 인자값
		1개로 부모의 멤버변수 2개를 초기화 할수 있도록 super()를
		정의하면 된다. 
	 */
    public Square(int width) {
    	super(width, width);
    }
    /*
    자식 객체를 통해 넓이를 구할때는 정사각형의 넓이가 나와야 하므로
    오버라이딩으로 정의해야 한다. 오버라이딩 된 메소드는 상속관계에서 
    항상 최하위의 메소드가 호출되게 된다. 
     */
    @Override
    public void ShowAreaInfo() {
    	System.out.println("정사각형넓이:"+(width*height));
    }
} 


public class QuRectangleMain {

	public static void main(String[] args) {
		
       	Rectangle rec = new Rectangle(4, 3);
       	rec.ShowAreaInfo();
 
       	Square sqr = new Square(7);
       	sqr.ShowAreaInfo();

	}
}
