package ex03.AOP;

public class CalcImpl implements iCalc {

	@Override
	public int add(int x, int y) {
		int result = x + y;
		return result;
	}

	@Override
	public int mul(int x, int y) {
		int result = x * y;
		return result;
	}

	@Override
	public int sub(int x, int y) {
		int result = x - y;
		return result;
	}
}
