package di;

//그래프상에서 원을 표현한 클래스
public class Circle {
	//멤버변수
	Point point;	//중심점에 해당하는 Point객체
	int radian;		//와 반지름을 멤버변수로 가짐.
	
	//생성자는 없고 getter/setter만 정의함. (<-> Point클래스)
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public int getRadian() {
		return radian;
	}
	public void setRadian(int radian) {
		this.radian = radian;
	}
	
	@Override
	public String toString() {
		return point + "반지름:" + radian;
	}
	
}
