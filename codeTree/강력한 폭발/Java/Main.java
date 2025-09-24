import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int N, maxBomb = 0, bombSize;
	private static int[][] map;
	private static boolean[][] visited;
	private static ArrayList<int[]>[] bombs;
	private static ArrayList<int[]> toExplode;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		init();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) toExplode.add(new int[] {i, j});
			}
		}
		
		bombSize = toExplode.size();
		comb(0);
		System.out.println(maxBomb);
	}
	private static void comb(int cnt) {
		if(cnt == bombSize) {
			bomb();
			visited = new boolean[N][N];
		}
		else {
			for(int i = 1; i <= 3; i++) {
				 int[] cur = toExplode.get(cnt);
				 map[cur[0]][cur[1]] = i;
				 comb(cnt + 1);
				 map[cur[0]][cur[1]] = 0;
			}
		}
	}
	private static void bomb() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					int bomb = map[i][j];
					
					for(int[] d : bombs[bomb]) {
						int nr = i + d[0];
						int nc = j + d[1];
						
						if(!isIn(nr, nc) || visited[nr][nc]) continue;
						visited[nr][nc] = true;
						cnt++;
					}
				}
			}
		}
		maxBomb = Math.max(maxBomb, cnt);
	}
	private static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
	private static void init() {
		bombs = new ArrayList[4];
		toExplode = new ArrayList<>();
		for(int i = 1; i <= 3; i++) {
			bombs[i] = new ArrayList<>();
		}
		
		bombs[1].add(new int[] {0, 0});
		bombs[1].add(new int[] {2, 0});
		bombs[1].add(new int[] {1, 0});
		bombs[1].add(new int[] {-2, 0});
		bombs[1].add(new int[] {-1, 0});
		
		bombs[2].add(new int[] {0, 0});
		bombs[2].add(new int[] {1, 0});
		bombs[2].add(new int[] {-1, 0});
		bombs[2].add(new int[] {0, 1});
		bombs[2].add(new int[] {0, -1});
		
		bombs[3].add(new int[] {0, 0});
		bombs[3].add(new int[] {1, 1});
		bombs[3].add(new int[] {1, -1});
		bombs[3].add(new int[] {-1, -1});
		bombs[3].add(new int[] {-1, 1});

	}

}
