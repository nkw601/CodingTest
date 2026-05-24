class Solution {
    int[][] dp;
    boolean[][] puddle;

    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n + 1][m + 1];
        puddle = new boolean[n + 1][m + 1];

        for (int[] p : puddles) {
            puddle[p[1]][p[0]] = true;
        }

        dp[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (y == 1 && x == 1) continue; // 시작점

                if (puddle[y][x]) { // 물웅덩이
                    dp[y][x] = 0;
                    continue;
                }

                dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % 1000000007;
            }
        }

        return dp[n][m];
    }
}