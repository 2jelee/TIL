package ex06;

public class InstanceBasic {
	public static void main(String[] args) {
		Tv tv;	       		 //참조변수 : tv
		tv = new Tv(); 		 // new 연산자로 공간 생성 + Tv 인스턴스 생성 | 대입연산자(=)로 생성된 주소값이 참조변수 tv에 저장
		tv.channel = 7; 	 // 참조변수+멤버변수
		tv.channelDown();    // 참조변수 tv가 참조하고 있는 Tv 인스턴스의 channelDown 메서드 호출
		System.out.println("현재 채널은 " +tv.channel+"입니다.");
	}
	
}
class Tv {
	String color;
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
}
