import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K, X;
	private static int[] dist;
	private static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시
		
		// X로부터 출발해 도달할 수 있는 도시 중, 최단거리가 K인 모든 도시의 번호
		dist = new int[N + 1];
		adjList = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
		}
		
		dijkstra();
		
		ArrayList<Integer> kCity = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			if(dist[i] == K) {
				kCity.add(i);
			}
		}
		
		if(kCity.isEmpty()) System.out.println(-1);
		else {
			for(int c : kCity) {
				System.out.println(c);
			}
		}
	}

	private static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		dist[X] = 0;
		pq.offer(new int[] {X, 0});
		
		while(!pq.isEmpty()) {
			int[] current = pq.poll();
			
			int curCity = current[0];
			int curWei = current[1];
			
			if(curWei > dist[curCity]) continue;
			
			for(int next : adjList[curCity]) {
				int nextWei = curWei + 1;
				if(nextWei < dist[next]) {
					dist[next] = nextWei;
					pq.offer(new int[] {next, nextWei});
				}
			}
		}
	}
}