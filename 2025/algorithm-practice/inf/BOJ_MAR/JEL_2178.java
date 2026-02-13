package etc_MAR;

/*
1. 처음에는 당연히 dfs인 줄 알고 dfs로 풀었다가 시간초과가 나서 bfs로 바꾸었다. 시간만 널널하면 dfs로 충분히 가능!
2. 미로 입력에 공백이 들어가지 않으므로, string으로 받고, 한 글자씩 map에 삽입한다.
3. 방문 체크를 위한 visited 배열을 준비하고, 첫 시작인 0,0 인덱스를 true로 설정한다.
4. 시작 인덱스 0,0을 넘기며 bfs 함수를 시작한다.
  4-1. 이동 가능한 칸들의 인덱스를 저장할 Queue를 선언한다. (x,y)쌍의 int형 배열을 저장.
  4-2. 넘겨받은 x,y를 int형 배열로 만들어 큐에 삽입.
5. 큐가 비어있지 않다면 반복
  5-1. 큐에서 원소 하나를 꺼내 각각 인덱스를 nowX, nowY에 저장한다.
  5-2. (nowX, nowY)를 기준으로 상하좌우를 확인해서 이동 가능한 인덱스가 있다면 그 인덱스를 큐에 저장한다.
  5-3. 그 인덱스의 값을 현재 인덱스(nowX, nowY)값보다 1 큰 값으로 설정한다.
  5-4. 그 인덱스의 방문체크를 한다.
 */ 

import java.io.IOException;
import java.util.Queue; 		  //BFS(너비우선탐색) => 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료구조인 큐를 사용 => FIFO
import java.io.BufferedReader;    //[알고리즘 최적화] 입력 받기 => Scanner(입력받은 문자 정규식 검사 후 문자열 반환) < BufferedReader(정규식 검사X)를 사용
import java.util.StringTokenizer; //[알고리즘 최적화] 한 줄 입력이 여러번 들어오는 경우 => split < StringTokenizer를 사용하여 파싱
import java.io.InputStreamReader; // '문자'를 처리
import java.util.LinkedList;

public class JEL_2178 {
	static int[][] map;
	static int n;
	static int m;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 }; 	// x방향 배열 : 상하
	static int[] dy = { 0, 0, -1, 1 };  // y방향 배열 : 좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][m];
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(map[n-1][m-1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});

        //큐가 끝날 때까지
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0; i<4; i++) {
                //다음 방문할 좌표 nextX, nextY
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				

                //다음 좌표가 범위를 넘어갈때 건너뛰기
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
        		    continue;
                
                //이미 방문했던 점이면 건너뛰기
		        if (visited[nextX][nextY] || map[nextX][nextY] == 0)
            		continue;
            
		        //다음에 방문할 좌표를 큐에 넣는다.
                q.add(new int[] {nextX, nextY});
                
                //배열안에 다음 방문할 곳은 현재 방문했던 점보다 1칸 더 가야하므로 +1
		        map[nextX][nextY] = map[nowX][nowY] + 1;
		        
		        //다음 좌표는 방문했음으로 표시
        		visited[nextX][nextY] = true;
			}
		}
	}
}