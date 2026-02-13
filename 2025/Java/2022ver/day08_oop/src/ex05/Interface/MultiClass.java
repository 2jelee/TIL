package ex05.Interface;

import ex02.Abstract.Shape;
import ex03.Interface.Test;

public class MultiClass extends Shape implements Test, IDraw {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("FROM IDraw interface");
	}

	@Override
	public void tView() {
		// TODO Auto-generated method stub
		System.out.println("FROM test interface");
		
	}

	@Override
	public double calc(double x) {
		// TODO Auto-generated method stub
		System.out.println("FROM shape class");
		return 1000;
	}

	@Override
	public void show(String name) {
		System.out.println(name);
	}

}
