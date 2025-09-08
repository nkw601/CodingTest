import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 
		
		int[] dp = new int[N + 3];
		
		dp[1] = 0;
		dp[2] = 1;
		
		for(int i = 2; i <= N; i++) {
			// 1. 1을 빼기
			dp[i] = dp[i-1] + 1;
			// 2. 2로 나누기
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
			// 3. 3으로 나누기
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
