import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] computers;
    static int N, cnt = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        computers = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            computers[i] = new ArrayList<Integer>();
        }

        int E = Integer.parseInt(br.readLine());
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            computers[n1].add(n2);
            computers[n2].add(n1);
        }
        dfs(0);
        for(int i = 1; i < N; i++){
            if(visited[i]) cnt++;
        }
        System.out.println(cnt);
    }
    static private void dfs(int idx) {
        for (int i = 0; i < computers[idx].size(); i++) {
            int next = computers[idx].get(i);
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}