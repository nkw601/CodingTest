import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	private static int N;
	private static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	private static char[][] map;
	private static boolean[][] visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int cnt = 0;
		ArrayList<Integer> sizes = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '1' && !visited[i][j]) {
					cnt++;
					visited[i][j] = true;
					sizes.add(dfs(i, j, 1));
				}
			}
		}
		
//		sizes.sort(new Comparator<Integer>() {	
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return Integer.compare(o2, o1);
//			}
//		});		
		
		Collections.sort(sizes);
		
		for(int size : sizes) {
			sb.append(size).append('\n');
		}
		
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	public static int dfs(int r, int c, int cnt) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isIn(nr, nc) && map[nr][nc] == '1' && !visited[nr][nc]) {
				visited[nr][nc] = true;
				cnt = dfs(nr, nc, cnt + 1);
			}
		}
		return cnt;
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}
