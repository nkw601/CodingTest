
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] stairs;
	static int[][] dp;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		stairs = new int[N];
		dp = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		if(N == 1) {
			System.out.println(stairs[0]);
			return;
		}
		
		dp[0][0] = stairs[0];
		dp[1][0] = stairs[1]; // 1개 
		dp[1][1] = stairs[0] + stairs[1]; // 연속 2개
		
		for(int i = 2; i < N; i++) {
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stairs[i]; // 저번 칸 건너뜀
			dp[i][1] = dp[i-1][0] + stairs[i]; // 저번 칸도 밟음
		}
		
		System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
		
	}

}
