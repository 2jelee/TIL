package ex03.quiz;

public class Quiz_Draw_solv {
	protected int w, h;
	protected double result;
	
	//생성자 함수
	public Quiz_Draw_solv() {
		w = h = 0; result = 0; //0으로 초기화
	}
	
	public Quiz_Draw_solv (int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}
	
	public Quiz_Draw_solv(int w) {
		super();
		this.w=w;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	//계산할 함수
	public double calc() { 
		return result;
	}

	@Override
	public String toString() {
		return "Quiz_Draw_solv [w=" + w + ", h=" + h + ", result=" + result + "]";
	}
	
	public void show() {
		System.out.println(w + ", " + h);
	}
}
