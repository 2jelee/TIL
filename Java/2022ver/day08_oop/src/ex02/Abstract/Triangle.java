package ex02.Abstract;

public class Triangle extends Shape {
	int w = 100;

	@Override
	public double calc(double x) {
		result = (x*w) /2;
		return result;
	}

	@Override
	public void show() {
		calc(9.0);
		System.out.println(result + " 크기의 " +name +"이 그려졌습니다.");
	}

	@Override
	public void show(String name) {
		// TODO Auto-generated method stub
		
	}
	
	

}
