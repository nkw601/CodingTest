import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[31][31];

        for (int m = 0; m <= 30; m++) {
            dp[0][m] = 1;
            dp[m][m] = 1;
        }

        for (int m = 1; m <= 30; m++) {
            for (int n = 1; n < m; n++) {
                dp[n][m] = dp[n - 1][m - 1] + dp[n][m - 1];
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(dp[N][M]).append('\n');
        }
        System.out.print(sb);
    }
}