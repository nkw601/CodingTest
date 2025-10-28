import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N, E, v1, v2;
	private static int[] dist;
	private static ArrayList<int[]>[] edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		make();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges[a].add(new int[] {b, c});
			edges[b].add(new int[] {a, c});
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		// 음
		// 1 ~ N번으로 가면서 v1, v2 필수로 가기
		int total1 = 0;

		boolean fir1 = dijkstra(1, v1);
		if (fir1) total1 += dist[v1];
		boolean sec1 = dijkstra(v1, v2);
		if (sec1) total1 += dist[v2];
		boolean last1 = dijkstra(v2, N);
		if (last1) total1 += dist[N];
		
		boolean first = fir1 && sec1 && last1;
		
		int total2 = 0;
		boolean fir2 = dijkstra(1, v2);
		if(fir2) total2 += dist[v2];
		boolean sec2 = dijkstra(v2, v1);
		if(sec2) total2 += dist[v1];
		boolean last2 = dijkstra(v1, N);
		if(last2) total2 += dist[N];
		
		boolean second = fir2 && sec2 && last2;
		
		if(!first && !second) System.out.println(-1);
		else if(first && second) System.out.println(total1 > total2 ? total2 : total1);
		else if(first) System.out.println(total1);
		else if(second) System.out.println(total2);
	}

	private static boolean dijkstra(int from, int to) {
		Arrays.fill(dist, 200000000);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] {from, 0});
		dist[from] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int c = cur[0];
			int cDist = cur[1];
			// 도착
			if(cur[0] == to) return true;
			
			if(dist[c] < cDist) continue;
			
			for(int next[] : edges[c]) {
				int ne = next[0];
				int wei = cDist + next[1];
				
				if(dist[ne] > wei) {
					dist[ne] = wei;
					pq.offer(new int[] {ne, wei});
				}		
			}
		}
		return false;
	}

	private static void make() {
		edges = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<int[]>();
		}
		
		dist = new int[N + 1];
		Arrays.fill(dist, 200000000);
	}

}
