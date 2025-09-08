

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] volumes = new int[N + 1];
			int[] values = new int[N + 1];
			
			// 입력
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				
				volumes[i] = Integer.parseInt(st.nextToken());
				values[i] = Integer.parseInt(st.nextToken());
			}
			
			//계산
			// knapsack 알고리즘: 
//			int[][] dp = new int[N + 1][K + 1];
			int[] dp = new int[K+1];
			// 선택 가능한 물건 0~N개까지 
			for(int n = 1; n <= N; n++) {
				for(int k = K; k >= 0; k--) {
					if(k - volumes[n] >= 0) {
						dp[k] = Math.max(dp[k], dp[k - volumes[n]] + values[n]);						
					} else {
						continue;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dp[K]).append('\n');
		}
		
		System.out.println(sb);
	}

}
