import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited, finished;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int x : result) {
            System.out.println(x);
        }
    }

    static void dfs(int now) {
        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            // 사이클 발견
            int cur = next;
            while (cur != now) {
                result.add(cur);
                cur = arr[cur];
            }
            result.add(now);
        }

        finished[now] = true;
    }
}