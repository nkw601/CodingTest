
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, canKnow;
	static ArrayList<Integer>[] taller, shorter;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			taller = new ArrayList[N];
			shorter = new ArrayList[N];
			for(int i = 0; i < N; i++) {
				taller[i] = new ArrayList<Integer>();
				shorter[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0 ; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s1 = Integer.parseInt(st.nextToken()) - 1;
				int s2 = Integer.parseInt(st.nextToken()) - 1;
				
				taller[s1].add(s2);
				shorter[s2].add(s1);
			}
			canKnow = 0;
			for(int i = 0; i < N; i++) {
				bfs(i);
			}
			
			sb.append("#").append(tc).append(" ").append(canKnow).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		
		boolean[] visited = new boolean[N];
		visited[start] = true;
		
		// 나보다 키 큰 사람
		int tallCnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int t : taller[cur]) {
				if(visited[t]) continue;
				visited[t] = true;
				q.offer(t);
				tallCnt++;
			}
			
		}
		
		// 나보다 키 작은 사람
		q.clear();
		q.add(start);
		visited = new boolean[N];
		visited[start] = true;
		int shortCnt = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int s : shorter[cur]) {
				if(visited[s]) continue;
				visited[s] = true;
				q.offer(s);
				shortCnt++;
			}
		}
		if(tallCnt + shortCnt == N - 1) canKnow++;
	}
}
/*
 * 입력
 * T
 * N
 * M
 * M: a b 비교
 * a < b
 * 
 * 출력
 * 자신의 키가 몇 번째인지 알 수 있는 학생이 모두 몇 명인지
 * 
 * 생각
 * bfs를 두 번 돌리면 된다는 스포를 들었습니다
 * 근데 뭘 기준으로 bfs를 돌리는 거지??
 * 
 * 1. 나보다 키 큰 사람 찾기
 * 2. 나보다 키 작은 사람 찾기
 * if) 나보다 키 큰 사람 + 작은 사람 = N - 1 : 내가 몇 번째인지 알 수 있음
 * 
 * */
