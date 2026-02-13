package etc_MAR.ref;

/*
[미로탐색 (DFS)]
7*7 격자판 미로를 탈출하는 경로의 가지 수를 출력하는 프로그램을 작성.
출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7) 좌표이다.
격자판의 1은 벽, 0은 통로이다.
격자판의 움직임은 상하좌우로만 움직인다.
 */

import java.util.Scanner;

class Inf_DFS10 {
	// 12시, 3시, 6시, 9시 방향
	static int[] dx = { -1, 0, 1, 0};  
	static int[] dy = { 0, 1, 0, -1};
	static int[][] board;
	static int answer=0;
	
	public void DFS(int x, int y) {
		//T.DFS(1, 1); 이후 작성
		if(x==7 && y==7) {
			answer++;
		}else {
			for (int i = 0; i <4; i++) { // 4방향 | i는 dx, dy에 접근하기 위한.
				int nx = x + dx[i]; //행
				int ny = y + dy[i]; //열
				
				// 경계선 밖인지 확인
				if(nx >=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0) { //이래야 경계선 안쪽이다. board[nx][ny]==0여야 통로(갈 수 있다)라는 의미
					board[nx][ny]=1; //갔으므로 1로 check
					DFS(nx, ny); //좌표로 넘어가면 호출
					
					//뒤로 back
					board[nx][ny]=0; //0으로 풀어주기
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Inf_DFS10 T = new Inf_DFS10();
		Scanner sc = new Scanner(System.in);
		board = new int[8][8]; //0번 인덱스부터가 X -> 1번 인덱스부터 사용하기 위해
		
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 7; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		board[1][1] = 1; // 출발점 체크 -> 1로
		T.DFS(1, 1); // 1, 1로 DFS 출발
		System.out.print(answer);
	}
}
