import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int n, m;
    private static int[] end = {-1, -1};
    private static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {end[0], end[1]});
        visited[end[0]][end[1]] = true;

        int cnt = 0;
        map[end[0]][end[1]] = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int s = 0; s < size; s++) {

                int[] cur = q.poll();
                map[cur[0]][cur[1]] = cnt;

                for(int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if(!isIn(nr, nc)) continue;
                    if(map[nr][nc] == 0) continue;
                    if(visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
            cnt++;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] != 0){
                    map[i][j] = -1;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
