import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
	private static int M, N;
	private static int[][] map, minDist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		minDist = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			Arrays.fill(minDist[i], Integer.MAX_VALUE);
			
			for(int j = 0; j < M; j++) {
				map[i][j] = arr[j] == '0' ? 0 : 1;
			}
		}
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		pq.offer(new int[] {0, 0, 0}); // r, c, 부순 벽 개수
		minDist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int cr = cur[0];
			int cc = cur[1];
			int wei = cur[2];
			
			
			if(cr == N - 1 && cc == M - 1) break;
			
			if(wei > minDist[cr][cc]) continue;

			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!isIn(nr, nc)) continue;
				
				int nWei = wei + map[nr][nc];
				if(nWei >= minDist[nr][nc]) continue;
				
				minDist[nr][nc] = nWei;
				pq.offer(new int[] {nr, nc, nWei});
			}
		}
		
		System.out.println(minDist[N - 1][M - 1]);
	}
	
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}
