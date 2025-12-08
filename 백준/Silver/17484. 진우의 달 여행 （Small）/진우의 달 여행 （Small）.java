import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] space = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        final int INF = Integer.MAX_VALUE;

        int[][][] fuel = new int[N][M][3];

        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                fuel[0][j][d] = space[0][j];
            }
        }

        int[] dir = {-1, 0, 1};

        for (int i = 1; i < N; i++) {

            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    fuel[i][j][d] = INF;
                }
            }

            for (int j = 0; j < M; j++) {
                for (int prevD = 0; prevD < 3; prevD++) {
                    int prevVal = fuel[i - 1][j][prevD];
                    if (prevVal == INF) continue;

                    for (int d = 0; d < 3; d++) {
                        if (d == prevD) continue;

                        int nj = j + dir[d];
                        if (nj < 0 || nj >= M) continue;

                        fuel[i][nj][d] = Math.min(
                                fuel[i][nj][d],
                                prevVal + space[i][nj]
                        );
                    }
                }
            }
        }

        int min = INF;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                min = Math.min(min, fuel[N - 1][j][d]);
            }
        }

        System.out.println(min);
    }
}