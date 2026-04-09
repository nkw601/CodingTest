import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N]; // 걸리는 기간
        int[] P = new int[N]; // 받는 금액

        int[] dp = new int[N + 1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N - 1; i >= 0; i--) {
            // i일차의 상담을 하면: dp[i + T[i]]와 비교
            if(i + T[i] > N) {
                dp[i] = dp[i + 1];
                continue;
            }
            dp[i] = Math.max(
                    P[i] + dp[i + T[i]],
                    dp[i + 1]
            );
        }

        System.out.println(dp[0]);
    }
}
