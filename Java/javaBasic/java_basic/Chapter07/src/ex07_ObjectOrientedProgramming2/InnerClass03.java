package ex07_ObjectOrientedProgramming2;

class InnerClass03 {
	private int outerIv = 0;
	static int outerCv = 0;
	
	class InstanceInner{
		int iiv = outerIv; //아우터 클래스의 ★private★ member에도 접근 O ★★★
		int iiv2 = outerCv;
	}

	static class StaticInner{
//		int siv = outerIv; // static class는 아우터 클래스의 인스턴스 멤버에 접근 X
		int siv2 = outerCv;
	}
	
	void myMethod() {
		int lv = 0;
		final int LV = 0; //final 생략 가능
		
		class LoalInner{
			int liv = outerIv;
			int liv2 = outerCv;
			
			int liv3 = lv; // JDK 1.8부터 error X
			int liv4 = LV; //OK
		}
	}
	
	
}
