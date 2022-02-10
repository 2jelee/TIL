package ex01.generic;

public class GenericEx<T> {
	//멤버변수
	T[] v; 		//type 아직 결정나지 않았다.
	
	//멤버함수
	public void set( T[] v) {
		this.v = v;
	}
	
	public void print() {
		for (T item : v) {
			System.out.println(item);
		}
	}
}
