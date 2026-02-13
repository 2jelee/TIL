package quiz.Di;

public class Soccer implements Player {
	
	// 선수이름, 포지션, 종목 이름 
	private String name, position, sport;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@Override
	public void info() {
		System.out.println("\n-- 선수 정보-- ");
		System.out.println("선수 이름 : " + this.name);
		System.out.println("포지션 : " + this.position);
		System.out.println("종목 이름 : " + this.sport);
	}

}





