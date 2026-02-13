package ex06;

class MyMath{
	long add(long a, long b) {
		long result = a + b;
		return result;
		//retun a+b;로 한 줄로 간단히 O
	}
	
	long subtract(long a, long b) {
		return a-b;
	}
	
	long multiply(long a, long b) {
		return a*b;
	}
	
	double divide(double a, double b) {
		return a/b;
	}
}

public class MethodFlow {
	public static void main(String[] args) {
		MyMath mm = new MyMath();
		long result1 = mm.add(5L, 3L);
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		double result4 = mm.divide(5L, 3L); //double 타입으로 선언했으나 이와 다른 long형의 값을 사용하여 호출하였다. OK
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}
}
