import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new boolean[N][N];
        visited = new boolean[N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            adjList[n1][n2] = true;
            adjList[n2][n1] = true;
        }
        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int idx){
        for(int i = 0; i < N; i++){
            if(!visited[i] && adjList[idx][i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}