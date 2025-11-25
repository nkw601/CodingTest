import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static boolean[][] visited, isSink;
	private static int N, maxSafe, maxDeep;
	private static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        maxSafe = maxDeep = 0;

        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		int n = Integer.parseInt(st.nextToken());
        		map[i][j] = n;
        		maxDeep = Math.max(n, maxDeep);
        	}
        }
        
        for(int i = 0; i <= maxDeep; i++) {
        	visited = new boolean[N][N];
        	isSink = new boolean[N][N];
        	makeSink(i);
        	
        	int cnt = 0;
        	for(int r = 0; r < N; r++) {
        		for(int c = 0; c < N; c++) {
        			if(!isSink[r][c] && !visited[r][c]) {
        				cnt++; // 안전구역 하나 추가
        				visited[r][c] = true;
        				dfs(r, c);
        			}
        		}
        	}
        	maxSafe = Math.max(maxSafe, cnt);
        }
        
        System.out.println(maxSafe);
	}
	
	// 가라앉은 지점 표시
	private static void makeSink(int limit) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] <= limit) isSink[i][j] = true;
			}
		}
		
	}

	private static void dfs(int r, int c) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isIn(nr, nc) && !visited[nr][nc] && !isSink[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c&& c < N;
	}
}
