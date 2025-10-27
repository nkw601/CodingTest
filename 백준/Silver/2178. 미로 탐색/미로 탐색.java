import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j] = input[j] - '0';
			}
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		int cnt = 0;
		out: while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for(int s = 0; s < size; s++) {
				int[] cur = q.poll();
				
				// 도착
				if(cur[0] == N - 1 && cur[1] == M - 1) {
					break out;
				}
				
				for(int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					
					if(isIn(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new int[] {nr, nc});
					}	
				}
			}
		}
			
		System.out.println(cnt);
	}
	
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

}
