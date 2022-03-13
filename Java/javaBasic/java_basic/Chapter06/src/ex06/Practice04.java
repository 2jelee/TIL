package ex06;

/*
 * 두 점의 거리를 계산하는 getDistance()를 완성하라.
 */

class Practice04{
	//두 점 (x, y)와 (x1, y1)간의 거리를 구한다.
	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));  //x, y는 지역변수
	}

	public static void main(String[] args) {
		System.out.println(getDistance(1, 1, 2, 2));
	}
}
