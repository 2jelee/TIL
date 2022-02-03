package ex06.oop;
 

/*
[클래스 설계]
class Circle {x, y, r}
class Rect {x, y, x2, y2}

문제1] class Sawn {
			이름, 직급, 부서, 급여, 연락처
			setter / getter method
			output method
*/

class Circle{
	int x, y, z;
	
	public int getX() {	return x; }
	public void setX(int xx) { x = xx; }
	public int getY() {	return y; }
	public void setY(int yy) { y = yy; }
	public int getZ() {	return z; }
	public void setZ(int zz) { z = zz; }
	
	// user method
	public void display() {
		System.out.println(x + y + z);		//같은 공간이므로 직접 접근 O
		System.out.println(getX() + ", " + getY());		//같은 공간이므로 직접 접근 O
	}
}

