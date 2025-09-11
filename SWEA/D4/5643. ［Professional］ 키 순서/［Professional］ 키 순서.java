
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, adj[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			adj = new int [N+1][N+1];
			// 메모 안된 상태로 초기화
			for(int i = 1; i < N + 1; i++) adj[i][0] = -1;
			
			for(int m =0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1; // a가 b보다 키가 큼
			}
			
			for(int i = 1; i <= N; i++) { // 모든 학생에 대해 탐색(이 과정에서 간접 관계를 직접 관계로 경로 압축)
				if(adj[i][0] == -1) dfs(i);
			}
			// 자신보다 작은 학생
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					adj[0][i] += adj[j][i];
				}
			}
		
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				if(adj[i][0] + adj[0][i]== N - 1) ans++;
			}
            sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}
	
	private static void dfs(int cur) {
		for(int i = 1; i <= N; i++) {
			if(adj[cur][i]==1 ) { // cur보다 큰 i라면
				if(adj[i][0] == -1) dfs(i); // i가 탐색을 하지 않았으면 탐색하러 가기
				
				// i가 탐색을 이미 해서 내려왔거나, i 탐색을 마치고 내려온 경우
				if(adj[i][0] > 0) { // i보다 큰 학생이 존재 -> cur < i < J ==> cur < J로 바꾸기
					for(int j = 0; j <= N; j++) { // i보다 큰 학생 J 찾아서 cur < J 관계로 표현
						if(adj[i][j] == 1) adj[cur][j] = 1;
					}
				}
			}
		}
		
		// 자신보다 큰 학생들 수 카운팅 후 메모
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(adj[cur][i] > 0) cnt++; // 나보다 큰 애 있으면 cnt++
		}
		adj[cur][0] = cnt;
	}

}
