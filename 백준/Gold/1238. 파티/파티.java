import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, X, maxTime = 0;
	private static int[] distTo, distFrom;
    private static ArrayList<int[]>[] arrList, revList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		
		distTo = new int[N];
		distFrom = new int[N];
		arrList = new ArrayList[N];
        revList = new ArrayList[N];

		for(int i = 0; i < N; i++) {
			arrList[i] = new ArrayList<>();
            revList[i] = new ArrayList<>();
		}
		
		Arrays.fill(distTo, Integer.MAX_VALUE);
		Arrays.fill(distFrom, Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from, to, wei;
			from = Integer.parseInt(st.nextToken()) - 1;
			to = Integer.parseInt(st.nextToken()) - 1;
			wei = Integer.parseInt(st.nextToken());
			arrList[from].add(new int[] {to, wei});
			revList[to].add(new int[]{from, wei});
		}
		
        dijkstra(arrList, distTo);
        dijkstra(revList, distFrom);
        
        for (int i = 0; i < N; i++) {
            if (distTo[i] == Integer.MAX_VALUE || distFrom[i] == Integer.MAX_VALUE) continue; // 도달 불가 보호
            maxTime = Math.max(maxTime, distTo[i] + distFrom[i]);
        }
		
		System.out.println(maxTime);
	}
	 private static void dijkstra(ArrayList<int[]>[] adjList, int[] dist) {
	        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
	        dist[X] = 0;
	        pq.offer(new int[]{X, 0});
	        
	        while (!pq.isEmpty()) {
	            int[] cur = pq.poll();
	            int curV = cur[0];
	            int curD = cur[1];
	            
	            if (curD > dist[curV]) continue;
	            
	            for (int[] edge : adjList[curV]) {
	                int next = edge[0];
	                int nextDist = curD + edge[1];
	                if (nextDist < dist[next]) {
	                    dist[next] = nextDist;
	                    pq.offer(new int[]{next, nextDist});
	                }
	            }
	        }
	 }

}
