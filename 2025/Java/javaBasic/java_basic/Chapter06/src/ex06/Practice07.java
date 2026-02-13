package ex06;

/*
 * 컴퓨터 게임의 병사(marine)를 클래스로 정의한 것이다. 이 클래스의 멤버 중에 static을 붙여야하는 것은 어떤 것들이고
 * 그 이유는 무엇인가?
 * (단, 모든 병사의 공격력과 방어력은 같아야 한다.)
 * 
 * weapon과 armor는 모든 Marine 인스턴스에 대해 동일한 값이어야 하므로.
 * weaponUp, armorUp은 static 변수에 대한 작업을 하는 메서드이므로.
 */
class Practice07 {
	int x = 0, y = 0; // Marine의 위치 좌표 (x, y)
	int hp = 60;
	int weapon = 6; //공격력
	int armor = 0; 	//방어력
	
	void weaponUp() {
		weapon++;
	}
	void armorUp() {
		armor++;
	}
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/********************************************************/

class Practice07_solv {
	int x = 0, y = 0; // Marine의 위치 좌표 (x, y)
	int hp = 60;
	static int weapon = 6; //공격력
	static int armor = 0;  //방어력
	
	static void weaponUp() {
		weapon++;
	}
	
	static void armorUp() {
		armor++;
	}
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}