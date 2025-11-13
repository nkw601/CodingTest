import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb;
	private static int N, M, V; // V: 시작 정점
	private static ArrayList<Integer>[] adjList;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		init();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		
        for (int i = 1; i <= N; i++) Collections.sort(adjList[i]);
        
		visited = new boolean[N + 1];
		dfs(V);
		
		sb.append("\n");
		
		Arrays.fill(visited, false);
		bfs(V);
		
		System.out.println(sb);
	}

	private static void init() {
		adjList = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
	}

	private static void dfs(int cur) {
		sb.append(cur).append(" ");
		visited[cur] = true;
		for(int next : adjList[cur]) {
			if(visited[next]) continue;
			dfs(next);
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(visited[cur]) continue;
			visited[cur] = true;
			
			sb.append(cur).append(" ");
			for(int next : adjList[cur]) {
				if(visited[next]) continue;
				q.offer(next);
			}
		}
	}
}
