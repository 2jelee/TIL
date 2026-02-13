package ex07_ObjectOrientedProgramming2;

class Point{
	int x, y;
	
	//constructor
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point{
	int z;
	
	//constructor
	Point3D(int x, int y, int z){
		super(x, y); //조상인 Point 클래스의 Point(int x, int y)를 호출
		this.z = z;
	}
}
public class SuperConstructor {
	public static void main(String[] args) {
		Point3D p3d = new Point3D(1, 2, 3);
		System.out.println("x = "+p3d.x+" | y = "+p3d.y+" | z = "+p3d.z);
	}
}
