package etc_MAR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JEL_1260 {
    static int N, M, V, start, end;
    static boolean[] visited;
    static int[][] map;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map[start][end] = map[end][start] = 1;
        }
        
        dfs(V);
        System.out.println();
        
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        
        bfs(V);
    }

    static void dfs(int point) {
        visited[point] = true;
        System.out.print(point + " ");

        for (int i = 1; i <= N; i++) {
            if (map[point][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    static void bfs(int startPoint) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startPoint);
        visited[startPoint] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int i = 1; i <= N; i++) {
                if (map[x][i] == 1 && visited[i] == false) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}