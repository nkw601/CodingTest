import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] map = new int[100001];
	static int[] visited = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(visited, Integer.MAX_VALUE);		
		System.out.println(bfs());
		
	}
	
	private static int bfs() {
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		q.offer(new int[] {N, 0});
		visited[N] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int time = cur[1];
			
			if (time > visited[cur[0]]) continue;
			if(cur[0] == K) return time;

			// 더하기
			int add = cur[0] + 1;
			int minus = cur[0] - 1;
			int multi = cur[0] * 2;
			
			if(add <= 100000 && visited[add] > time + 1) {
				visited[add] = time + 1;
				q.offer(new int[] {add, time + 1});
			}
			if(minus >= 0 && visited[minus] > time + 1) {
				visited[minus] = time + 1;
				q.offer(new int[] {minus, time + 1});
			}
			if(multi <= 100000 && visited[multi] > time) {
				visited[multi] = time;
				q.offer(new int[] {multi, time});
			}
			
		}
		
		return -1;
	}
}

/*
 * 입력
 * N K(수빈, 동생)
 * 
 * 출력
 * 동생을 찾는 최소 시간
 * 
 * 이해
 * 1. 수빈이의 행동
 * - 걷기: X - 1 // X + 1(1초)
 * - 순간이동: 2*X(0초)
 * 
 * 생각
 * 걍 BFS 아닌가?
 * 아 시간 터질듯
 * DP? 아니 DP라고? DP 아니지,, -1이 있는데..
 * 다익이었던 것 같은데
 * 이게 어떻게 다익스트라일까~...
 */