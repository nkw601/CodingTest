import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new int[15][15];

        // 0층 채우기
        for(int i = 0; i < 15; i++) {
            dp[0][i] = i;
        }

        // 0라인 채우기
        for(int i = 0; i < 15; i++) {
            dp[i][1] = 1;
        }

        // 나머지 채우기
        for(int k = 1; k < 15; k++) {
            for(int n = 1; n < 15; n++) {
                dp[k][n] = dp[k][n - 1] + dp[k - 1][n];
            }
        }

        int T = Integer.parseInt(br.readLine());
        int k, n;
        for(int tc = 1; tc <= T; tc++) {
            k = Integer.parseInt(br.readLine()); // k층
            n = Integer.parseInt(br.readLine()); // n호

            sb.append(dp[k][n]).append('\n');
        }

        System.out.println(sb);
    }
}

// 0층의 i호: i명
// 1층의 i호: i명?

// 0층의 1호: 1명
// 2호: 2명
// 3호: 3명? 아하 1씩 는다고
// i ~ i + n의 합
// i (i + n + 1)