package etc_FEB;

/*
[톱니바퀴 (2)]

총 8개의 톱니를 가지고 있는 톱니바퀴 T개가 아래 그림과 같이 일렬로 놓여져 있다. 또, 톱니는 N극 또는 S극 중 하나를 나타내고 있다. 톱니바퀴에는 번호가 매겨져 있는데, 가장 왼쪽 톱니바퀴가 1번, 그 오른쪽은 2번, ..., 가장 오른쪽 톱니바퀴는 T번이다. 아래 그림은 T가 4인 경우이다.

이때, 톱니바퀴를 총 K번 회전시키려고 한다. 톱니바퀴의 회전은 한 칸을 기준으로 한다. 회전은 시계 방향과 반시계 방향이 있고, 아래 그림과 같이 회전한다.

톱니바퀴를 회전시키려면, 회전시킬 톱니바퀴와 회전시킬 방향을 결정해야 한다. 톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를 회전시킬 수도 있고, 회전시키지 않을 수도 있다. 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다. 예를 들어, 아래와 같은 경우를 살펴보자.

두 톱니바퀴의 맞닿은 부분은 초록색 점선으로 묶여있는 부분이다. 여기서, 3번 톱니바퀴를 반시계 방향으로 회전했다면, 4번 톱니바퀴는 시계 방향으로 회전하게 된다. 2번 톱니바퀴는 맞닿은 부분이 S극으로 서로 같기 때문에, 회전하지 않게 되고, 1번 톱니바퀴는 2번이 회전하지 않았기 때문에, 회전하지 않게 된다. 따라서, 아래 그림과 같은 모양을 만들게 된다.

위와 같은 상태에서 1번 톱니바퀴를 시계 방향으로 회전시키면, 2번 톱니바퀴가 반시계 방향으로 회전하게 되고, 2번이 회전하기 때문에, 3번도 동시에 시계 방향으로 회전하게 된다. 4번은 3번이 회전하지만, 맞닿은 극이 같기 때문에 회전하지 않는다. 따라서, 아래와 같은 상태가 된다.

톱니바퀴 T개의 초기 상태와 톱니바퀴를 회전시킨 방법이 주어졌을 때, 최종 톱니바퀴의 상태를 구하는 프로그램을 작성하시오.

입력 :
첫째 줄에 톱니바퀴의 개수 T (1 ≤ T ≤ 1,000)가 주어진다. 
둘째 줄부터 T개의 줄에 톱니바퀴의 상태가 가장 왼쪽 톱니바퀴부터 순서대로 주어진다. 상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.
다음 줄에는 회전 횟수 K(1 ≤ K ≤ 1,000)가 주어진다. 다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다. 각 방법은 두 개의 정수로 이루어져 있고, 첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다. 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.

출력 : 총 K번 회전시킨 이후에 12시방향이 S극인 톱니바퀴의 개수를 출력한다.

예제 입력 :
4
10101111
01111101
11001110
00000010
2
3 -1
1 1

예제 출력 :
3
*/

import java.util.Scanner;

public class Main15662 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int wheel = 8;
		int n = sc.nextInt();
		Gear[] g = new Gear[n];
		
		for(int i=0; i<n; i++) {
			int toothWheel = new int[wheel];
			String line = sc.next();
			for(int j=0; j<wheel; j++) {
				toothWheel[j] = line.charAt(j) - '0';
			}
			g[i] = new Gear(toothWheel);
		}
		
		int moveCount = sc.nextInt();
		while(moveCount-- > 0) {
			int gearNum = sc.nextInt();
			int movement = sc.nextInt();
//			IterMovement(gearNum-1, movement, g);
		}
		
		int count = 0;
		for(int i=0; i<n; i++) {
//			if(g[i].getTweleveSawTooth()==1) {
//				count++;;
//			}
		}
		System.out.println(count);
	}
	
	public static class Gear{
		private int[] ToothWheel;
		private int wheel;
		private int startIndex;
		
		public Gear(int[] toothWheel) {
			startIndex = 6;
			wheel = 8;
		}

		public int[] getToothWheel() {
			return ToothWheel;
		}

		public void setToothWheel(int[] toothWheel) {
			ToothWheel = toothWheel;
		}

		public int getWheel() {
			return wheel;
		}

		public void setWheel(int wheel) {
			this.wheel = wheel;
		}

		public int getStartIndex() {
			return startIndex;
		}

		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}
		
		public void moveLeft() {
			startIndex += 1;
			startIndex %= wheel;
		}
		
		public void moveRight() {
			startIndex += wheel-1;
			startIndex %= wheel;
		}
	}
}
