import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, N;
	private static boolean map[][], visited[][];
	private static int delta[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = st.nextToken().equals("1")? true : false;
			}
		}
		
		N = Integer.parseInt(br.readLine());
		delta = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			delta[i][0] = Integer.parseInt(st.nextToken());
			delta[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 1. 세로 블록만 밟기
		// 2. 특정 규칙으로 이동하기
		// 3. 첫 번째 row -> 마지막 row
		// 4. 최소
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		int cnt = 0;
		
		// 0 행 세로블럭 넣기
		for(int c = 0; c < C; c++) {
			if(map[0][c] == true) {
				q.offer(new int[] {0, c});
				visited[0][c] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {				
				int[] cur = q.poll();
				
				// 종결 조건
				if(cur[0] == R - 1) return cnt;
				for(int d = 0; d < N; d++) {
					int nr = cur[0] + delta[d][0];
					int nc = cur[1] + delta[d][1];
					
					if(!isIn(nr, nc)) continue;
					if(map[nr][nc] == false) continue;
					if(visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
			cnt++;
		}
		
		return -1;
	}
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}

}
