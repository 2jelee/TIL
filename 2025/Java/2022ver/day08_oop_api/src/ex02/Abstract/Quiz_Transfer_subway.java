package ex02.Abstract;

/*
 * 문제1.
 * Trans 추상클래스 <--- 부모는 모든 자손에게 상속할 수 있는 최소한의 것 추상메소드 start()/ stop()
 * public String name(String name){
 * 		return name;
 * }
 * 
 * sub class : subway / bus / bicycle / airPlain
 * MainEntry에서 메인 함수 구현하기
 */
abstract class Quiz_Transfer_subway extends Quiz_Transfer {
	String sound;

	@Override
	public String start() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String stop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sound(String name) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
