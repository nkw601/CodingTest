
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class Worm{
		long x, y;

		public Worm(long x, long y){
			this.x = x;
			this.y = y;
		}
	}
	
	
	private static int N;
	private static Worm[] worms;
	private static long totalX, totalY, minDist, groupX, groupY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			worms = new Worm[N];
			totalX = totalY = groupX = groupY = 0;
			minDist = Long.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Long x, y;
				x = Long.parseLong(st.nextToken());
				y = Long.parseLong(st.nextToken());
				worms[i] = new Worm(x, y);
				totalX += x;
				totalY += y;
				
			}
			
			dfs(0, 0);
			sb.append('#').append(tc).append(' ').append(minDist).append('\n');
		}
		System.out.println(sb);
	}
	static void dfs(int idx, int cnt) {
		int need = N / 2 - cnt;
		int left = N - idx;
		
		if(need > left) return;
		
		if (cnt == N / 2) {
            long vx = 2 * groupX - totalX;
            long vy = 2 * groupY - totalY;
            long val = vx * vx + vy * vy;
            if (val < minDist) minDist = val;
            return;
        }
        if (idx == N) return;
        
        // 선택 안함
        dfs(idx + 1, cnt);

        groupX += worms[idx].x;
        groupY += worms[idx].y;
        dfs(idx + 1, cnt + 1);
        
        // 백트래킹
        groupX -= worms[idx].x;
        groupY -= worms[idx].y;
	}
}