import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, time, remain, toMelt;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	static boolean[][] cheese, visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cheese = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				boolean c = st.nextToken().equals("1");
				cheese[i][j] = c;
				if(c) remain++;
		
			}
		}
		
		visited = new boolean[R][C];
		while(remain > 0) {
			toMelt = 0;
			// 모서리에서 출발해서 모든 공기층 확인 -> 항상 가장 바깥은 비어있음
			bfs(0, 0);
			
			if(remain == toMelt) {
				time++;
				break;
			}
			
			time++;
			remain -= toMelt;
		}
		
		System.out.println(time);
		System.out.println(remain);
	}
	private static void bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();
		// if !visited && 치즈가 있다면 -> 그 치즈는 녹을 치즈 -> 꺼내서 처리해야함 
		visited = new boolean[R][C];
		q.offer(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				
				if(isIn(nr, nc) && !visited[nr][nc]) {
					if(!cheese[nr][nc]) { // 공기면
						visited[nr][nc] = true;
						q.offer(new int[] {nr, nc});
					} else { // 치즈면: 녹이고 카운트 ++하고 탐색 종료
						visited[nr][nc] = true;
						toMelt++;
						cheese[nr][nc] = false;
					}
				}
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}

/*
 * 다올 샘의 힌트: 치즈부터 bfs를 시작하는게 아니라 공기부터 시작하기
 */