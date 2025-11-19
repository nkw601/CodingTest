import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, start, end;
	private static ArrayList<int[]>[] edges;
	private static int[] costs, prevCities;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 도시의 개수 N(정점), 버스의 개수 M(간선)
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		init();
		
		// 출발-도착-비용
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edges[from].add(new int[] {to, cost});
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra(start, end);
		
		Stack<Integer> stack = new Stack();
		int cur = end;
		int cnt = 0;
		while(cur != -1) {
			stack.add(cur);
			cnt++;
			cur = prevCities[cur];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(costs[end]).append("\n").append(cnt).append("\n");
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb);
	}
	
	@SuppressWarnings("unchecked")
	private static void init() {
		edges = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		
		costs = new int[N + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		prevCities = new int[N + 1];
		Arrays.fill(prevCities, -1);
	}
	
	private static void dijkstra(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		
		pq.offer(new int[] {start, 0}); // 현재 위치, 비용
		costs[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			int cur = current[0];
			int weight = current[1];

			if(cur == end) return;
			if(costs[cur] < weight) continue; // 더 볼 필요 없음
			
			for(int[] next : edges[cur]) {
				int nCity = next[0];
				int nWei = next[1] + weight;
				
				if(nWei < costs[nCity]) { // 최소 비용이 갱신되었으면
					costs[nCity] = nWei;
					pq.offer(new int[] {nCity, nWei});
					
					// 이전 도시 저장
					prevCities[nCity] = cur;
					
				}
			}
		}
	}
}
