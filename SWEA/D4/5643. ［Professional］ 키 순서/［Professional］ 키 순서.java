
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, adj[][];
	static int count; // 자신보다 키가 크거나 작은 학생 수
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			adj = new int [N+1][N+1];
			for(int m =0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1; // a가 b보다 키가 큼
			}
			int ans = 0;
			for(int i = 1; i <= N; i++) { // 모든 학생에 대해 탐색
				count = 0;
				boolean[] visited = new boolean[N+1];
				gtDFS(i, visited); // 나보다 큰 학생 수를 count에 저장
				ltDFS(i, visited); // 나보다 작은 학생 수를 count에 더함
				
				if(count == N - 1) {
					ans++;
				}
				
			}
			sb.append("#").append(tc + 1).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void gtDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for(int i = 1; i <= N; i++) {
			if(adj[cur][i]==1 && !visited[i]) {
				++count;
				gtDFS(i, visited);
			}
		}
	}
	private static void ltDFS(int cur, boolean[] visited) {
		visited[cur] = true;
		for(int i = 1; i <= N; i++) {
			if(adj[i][cur]==1 && !visited[i]) {
				++count;
				ltDFS(i, visited);
			}
		}
	}
}
