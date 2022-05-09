package ex05.AOP;

public class CalcImpl implements iCalc {
	@Override
	public int add(int x, int y) {
		// 보조 관심(cross-cutting-concern)
		int result = x + y;
		// 보조 관심
		System.out.println("add 주 관심사");
		return result;
	}

	@Override
	public int mul(int x, int y) {
		int result = x * y; //주 관심사 
		return result;
	}

	@Override
	public int sub(int x, int y) {
		int result = x - y;
		return result;
	}
}
