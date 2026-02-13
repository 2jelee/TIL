package ex03.argumentVariable;

public class MainEntry {
	
	//가변길이 배열		>>자료형이 동일한 경우
	public static void plus(int ... x) {
		int sum=0; //※ 누적할 함수는 초기화 해주자
		for(int i=0; i<x.length; i++) {
			sum += x[i];
		}
//		System.out.println("sum = " + sum);
		
		for(int i=0; i<x.length; i++) {
			System.out.println(x+"["+i+"]="+sum);
		}
	}
	
	public static void plus(String ... x) { //변수명 같
		String str = ""; //초기화
		for(int i=0; i<x.length; i++) {
			str += x[i];
		}
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		//자료형 int
		plus(3);
		plus(1,2,3,4,5,6,7,8);
		plus(100, 20);
		
		//자료형 string
		plus("kbs ", "mbc ", "KOSA");
		plus("A ", "B");
	}
}
