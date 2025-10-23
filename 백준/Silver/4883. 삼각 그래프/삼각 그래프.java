import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		long [][] map, dp;
		
		int N = Integer.parseInt(br.readLine());
		int tc = 1;
		
		while(N != 0) {
			map = new long[N][3];
			dp = new long[N][3];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Long.parseLong(st.nextToken());
				map[i][1] = Long.parseLong(st.nextToken());
				map[i][2] = Long.parseLong(st.nextToken());
				
				if(i == 0) { // 시작점: map[0][1] 고정
					dp[0][0] = dp[0][1] = map[0][1];
					dp[0][2] = dp[0][1] + map[0][2];
				} else {
					dp[i][0] = Math.min(dp[i - 1][0], dp[i  - 1][1]) + map[i][0];
					dp[i][1] = Math.min(Math.min(Math.min(dp[i - 1][0], dp[i  - 1][1]), dp[i - 1][2]), dp[i][0]) + map[i][1];
					dp[i][2] = Math.min(Math.min(dp[i - 1][1], dp[i  - 1][2]), dp[i][1]) + map[i][2];
				}
			}
			sb.append(tc).append(". ").append(dp[N-1][1]).append("\n");

			N = Integer.parseInt(br.readLine());
			tc++;
		}
		System.out.println(sb);
	}

}
