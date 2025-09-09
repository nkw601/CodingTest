
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] numbers, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			numbers = new int[N + 1];
			dp = new int[N + 1];
			int maxLen = 1;
			// dp: 초기값은 1
			// numbers[i]를 가장 큰 값으로 뒀을 때의 maxLen
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				dp[i] = 1;
				numbers[i] = Integer.parseInt(st.nextToken());
				
				// 내 앞 원소들에 대해
				for(int j = 1; j < i; j++) {
					if(numbers[i] > numbers[j]) {
						dp[i] = Math.max(dp[j] + 1, dp[i]);
					}
				}
				maxLen = Math.max(maxLen, dp[i]);
			}
			
			sb.append("#").append(tc).append(" ").append(maxLen).append('\n');
		}
		System.out.println(sb);
	}

}
