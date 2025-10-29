import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	private static int N;
	private static int[][] map, dist;
	
	private static int dr[] = {-1, 1, 0, 0};
	private static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i < N; i++)
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			
			for(int i = 0; i < N; i++) {
				char[] arr = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = arr[j] - '0';
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dijkstra()).append('\n');
		}
		
		System.out.println(sb);
	
	}

	private static int dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		pq.offer(new int[] {0, 0, 0});
		dist[0][0] = 0;
	
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			int cr = current[0];
			int cc = current[1];
			int curWei = current[2];
			
			if(cr == N - 1 && cc == N - 1) break; // 도착
			
			if(curWei > dist[cr][cc]) continue;
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!isIn(nr, nc)) continue;
				
				int nWei = curWei + map[nr][nc];
				if(nWei < dist[nr][nc]) {
					dist[nr][nc] = nWei;
					pq.offer(new int[] {nr, nc, nWei});
				}
			}
		}
		
		
		return dist[N - 1][N - 1];
	}
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}
