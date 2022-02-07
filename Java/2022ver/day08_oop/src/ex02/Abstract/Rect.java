package ex02.Abstract;

public abstract class Rect extends Shape {
	int h = 100;

	@Override
	public double calc(double x) {
		result = x * h;
		return result;
	}

	@Override
	public void show(String name) {
		calc(8.8);
		System.out.println(result + " 크기의 "+name+"이 만들어졌습니다.");
	}
	
}
