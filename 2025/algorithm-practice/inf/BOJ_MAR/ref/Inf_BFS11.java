package etc_MAR.ref;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
[미로의 최단거리 통로 (BFS)]
7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성.
경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미함.
출발점은 격자의 (1, 1) 좌표이고 탈출 도착점은 (7, 7)좌표이다.
격자판의 1은 벽이고 0은 도로다.
격자판의 움직임은 상하좌우로만 움직인다.
 */

class Point{
	public int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Inf_BFS11 { 
	static int[] dx = { -1, 0, 1, 0 };  
	static int[] dy = { 0, 1, 0, -1};
	static int[][] board, dis;
//	static int answer=0;
	
	public void BFS(int x, int y) { 
		// Point라는 클래스를 저장할 수 있는
		Queue<Point> q = new LinkedList<>();
		
		// 객체(좌표) 넣기 offer
		q.offer(new Point(x, y));
		board[x][y] = 1; //출발점
		
		while(!q.isEmpty()) {
			Point temp = q.poll(); // 꺼내기 poll
			// BFS는 퍼져나가야 한다.
			for (int i = 0; i < 4; i++) {
				//temp.x, temp.y = 현재 좌표를 의미
				int nx = temp.x + dx[i]; //행
				int ny = temp.y + dy[i]; //열
				
				//경계선 안에
				if(nx >=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0) {
					board[nx][ny]=1; //가면 check(1)
					q.offer(new Point(nx, ny)); // Queue에 넣어주기
					dis[nx][ny] = dis[temp.x][temp.y]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Inf_BFS11 T = new Inf_BFS11();
		Scanner sc = new Scanner(System.in);
		board = new int[8][8]; //0번 인덱스부터가 X -> 1번 인덱스부터 사용하기 위해
		dis = new int[8][8];
		
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		T.BFS(1, 1); // 1, 1 => 출발점 | 넘기기
		
		// BFS의 경우 해당 코드 추가
		if(dis[7][7]==0) {
			System.out.println(-1); //도착할 수 없으면 -1 출력
		} else {
			System.out.print(dis[7][7]);
		}
	}
}
