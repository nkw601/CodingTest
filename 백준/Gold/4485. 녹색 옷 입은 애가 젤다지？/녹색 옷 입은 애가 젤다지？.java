import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, dist;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		int tc = 0;
		while(N != 0) {
			// 초기화
			map = new int[N][N];
			dist = new int[N][N];
			
			// 입력
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			
			sb.append("Problem ").append(++tc).append(": ").append(dist[N-1][N-1]).append('\n');
			
			N = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
	}
	static void dijkstra() {
		dist[0][0] = map[0][0];
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		q.add(new int[] {0, 0, dist[0][0]});
		
		while(!q.isEmpty()) {
			int[] min = q.poll();
			int cr = min[0];
			int cc = min[1];
			int cco = min[2];
			
			if(cr == N-1 && cc == N-1) return;
			if(cco > dist[cr][cc]) continue;
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(!isIn(nr, nc)) continue;
				int nCost = dist[cr][cc] + map[nr][nc];
				
				if(nCost < dist[nr][nc]) {
					dist[nr][nc] = nCost;
					q.offer(new int[] {nr, nc, nCost});
				}
			}
			
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}

/*
 * 생각을 해봅시다
 * (i, j)칸에 가는 방법
 * 1. (i - 1, j)에서 온다
 * 2. (i, j - 1)에서 온다
 */