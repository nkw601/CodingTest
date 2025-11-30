import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] visited, farm;
    private static int M, N, K, cnt;
    private static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            farm = new boolean[N][M];

            for (int i = 0; i < K ; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());;
                int r = Integer.parseInt(st.nextToken());

                farm[r][c] = true;
            }

            cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(farm[i][j] && !visited[i][j]){
                        cnt++;
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
    private static boolean isIn(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {r, c});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for(int d = 0; d < 4; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(isIn(nr, nc) && farm[nr][nc] && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }

    }
}