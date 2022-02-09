package ex05.Interface;

import ex02.Abstract.Shape;
import ex03.Interface.Test;

public interface MainEntry2 {
	public static void main(String[] args) {
		
		//2-1. super
		Shape s = new MultiClass();
		s.calc(5.5);
		s.show("도형입니다.");
		s.view();
		
		/**********************************/

		//2-2. super
		Test t = new MultiClass();
		t.tView();
		System.out.println(t.num);
		
		/**********************************/
		
		//1.
		MultiClass mc = new MultiClass();
		mc.draw();
		System.out.println(mc.su);
		System.out.println(mc.num);
	}
}
