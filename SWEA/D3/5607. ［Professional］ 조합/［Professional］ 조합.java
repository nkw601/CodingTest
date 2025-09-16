
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static final long MOD = 1234567891L;
	private static long[] factorial;
	private static int[] NList, RList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
			
		int T = Integer.parseInt(br.readLine());
		NList = new int[T + 1];
		RList = new int[T + 1];
		int maxN = 0;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            NList[tc] = n; RList[tc] = r;
            if (n > maxN) maxN = n;
            
			// 터졌다...
//			dp = new int[N + 1][R + 1];
//			dp[1][0] = dp[1][1] = 1;
//			for(int i = 2; i <= N; i++) {
//				for(int j = 0; j <= R; j++) {
//					if(j == 0) dp[i][j] = dp[i - 1][j];
//					else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 1234567891;
//				}
//			}	
		}
		
		makeFactorial(maxN);

		for(int tc = 1; tc <= T; tc++) {
			int n = NList[tc];
			int r = RList[tc];
			long ans;
			
			if (r < 0 || r > n) {
                ans = 0;
            } else if (r == 0 || r == n) {
                ans = 1;
            } else {
                ans = factorial[n];
                
                long powed = (factorial[r]*factorial[n - r]) % MOD;
                powed = PowNum(powed);
                
                ans = (ans * powed) % MOD;
            }
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
			
		}
		System.out.println(sb);
	}
	private static long PowNum(long num) {
	    long exp = MOD - 2;     // 지수 = MOD-2
	    long base = num % MOD;  // 밑
	    long res = 1;           // 결과 누적

	    while (exp > 0) {
	        if ((exp & 1) == 1) {       // 지수의 현재 비트가 1이면
	            res = (res * base) % MOD;
	        }
	        base = (base * base) % MOD; // base 제곱
	        exp >>= 1;                  // 지수 절반
	    }
	    return res;
	}

	private static void makeFactorial(int n) {
		factorial = new long[n + 1];
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) factorial[i] = (factorial[i - 1] * i) % MOD;
	}

}
