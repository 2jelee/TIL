package ex05method;
/*
문제5-3) 파일명 : QuTemperature.java  (난이도:중)
섭씨(Celsius)를 입력받아서 화씨(Fahrenheit)로 변환하여 리턴하는 
함수와 화씨를 입력받아서 섭씨로 변환하여 리턴하는 함수를 만들어라.

공식]
화씨 = 1.8 * 섭씨 + 32
섭씨 = (화씨 - 32) / 1.8
 */
public class QuTemperature {

	//섭씨->화씨..
	static double celsiusToFahrenheit(double cel) {
		return 1.8 * cel + 32;
	}
	
	//화씨->섭씨..
	static double fahrenheitToCelsius(double fah) {
		double result = (fah - 32) / 1.8;
		return result;
	}
	
	public static void main(String[] args) {
		/*
		인자로 전달하는 18은 정수이고, 매개변수 cel은 실수이므로
		전달될때 자동형변환이 일어난다. 
		 */
		System.out.println("섭씨18도->화씨="+ celsiusToFahrenheit(18));
		System.out.println("화씨98도->섭씨="+ fahrenheitToCelsius(98.2));
	}

}
