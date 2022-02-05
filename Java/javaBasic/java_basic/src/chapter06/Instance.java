package chapter06;

public class Instance {
	public static void main(String[] args) {
		//객체 생성
		Tv t;							//Tv인스턴스를 참조하기 위한 변수 t를 선언
		t = new Tv();					//Tv인스턴스를 생성
		
		//객체 사용
		t.channel = 7;  //변수사용	    //Tv인스턴스의 멤버변수 channel의 값을 7로
		t.channelDown();//메서드 사용   //Tv인스턴스의 메서드 channelDown()을 호출	
		System.out.println("현재 채널은 " + t.channel + "입니다." );
	}
	
	class Tv{
		//Tv의 속성 [멤버변수]
		String color;
		boolean power;	//전원상태(on/off)
		int channel;
		
		//Tv의 기능 [메서드]
		void power() { power = !power; }	//TV를 켜거나 끄는 기능을 하는 메서드
		void channelUp() { ++channel; }		//TV의 채널을 올리는 기능을 하는 메서드
		void channelDown() { --channel; }	//TV의 채널을 낮추는 기능을 하는 메서드
		
	}
}
