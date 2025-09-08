import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, s, e;
	static int[] distance;
	static ArrayList<int[]>[] edges;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		// 초기화
		distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		edges = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			edges[i] = new ArrayList<int[]>();
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from, to, weight;
			from = Integer.parseInt(st.nextToken()) - 1;
			to = Integer.parseInt(st.nextToken()) - 1;
			weight = Integer.parseInt(st.nextToken());
			
			edges[from].add(new int[] {to, weight});
		}
		
		st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken()) - 1;
		e = Integer.parseInt(st.nextToken()) - 1;
		
		dijkstra(s);
		System.out.println(distance[e]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		distance[start] = 0;
		
		pq.offer(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int to = cur[0];
			int weight = cur[1];
			
			if(to == e) return;
			if(weight > distance[to]) continue;
			
			for(int[] n: edges[to]) {
				int nextNode = n[0];
				int nextWei = n[1] + weight;
				
				if(distance[nextNode] > nextWei) {
					distance[nextNode] = nextWei;
					pq.offer(new int[] {nextNode, nextWei});
				}
			}
		}
	}
}
