package etc_MAR;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; 

class Point{
	public int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class JEL_14716 {
	static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1}; 
	static int[][] board, dis;
	
	public void BFS(int x, int y) {  
		Queue<Point> q = new LinkedList<>();
		 
		q.offer(new Point(x, y));
		board[x][y] = 1;  
		
		while(!q.isEmpty()) {
			Point temp = q.poll();  
			for (int i = 0; i < 8; i++) { 
				int nx = temp.x + dx[i];  
				int ny = temp.y + dy[i];  
				 
				if(nx >=1 && nx<=8 && ny>=1 && ny<=19 && board[nx][ny]==0) {
					board[nx][ny]=1;  
					q.offer(new Point(nx, ny));
					dis[nx][ny] = dis[temp.x][temp.y]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		JEL_14716 T = new JEL_14716();
		Scanner sc = new Scanner(System.in);
		board = new int[9][20];  
		dis = new int[9][20];
		
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 19; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		T.BFS(1, 1); 
		if(dis[8][19]==0) { System.out.println(-1); } 
		else { System.out.print(dis[8][19]); }
	}
}