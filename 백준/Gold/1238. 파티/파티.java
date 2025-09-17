
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
	private static ArrayList<int[]>[] arrList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		
		distTo = new int[N];
		distFrom = new int[N];
		arrList = new ArrayList[N];
		
		for(int i = 0; i < N; i++) arrList[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from, to, wei;
			from = Integer.parseInt(st.nextToken()) - 1;
			to = Integer.parseInt(st.nextToken()) - 1;
			wei = Integer.parseInt(st.nextToken());
			arrList[from].add(new int[] {to, wei});
		}
		for(int i = 0; i < N; i++) {
			Arrays.fill(distTo, Integer.MAX_VALUE);
			Arrays.fill(distFrom, Integer.MAX_VALUE);
			int time = dijkstra(i);			
			maxTime = Math.max(time, maxTime);
		}
		System.out.println(maxTime);
	}
	private static int dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		// 집 -> X 마을
		distFrom[start] = 0;
		pq.offer(new int[] {start, 0});
		
		out: while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int curV = cur[0];
			int curDist = cur[1];
			
			if(curDist > distFrom[curV]) continue;
			if(curV == X) break out;
			
			for(int[] edge : arrList[curV]) {
				int next = edge[0];
				int nextDist = curDist + edge[1];
				
				if(nextDist < distFrom[next]) {
					distFrom[next] = nextDist;
					pq.offer(new int[] {next, nextDist});
				}
			}
			
		}
		
		// X 마을 -> 집
		pq.clear();
		pq.offer(new int[] {X, 0});
		distTo[X] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			int curV = cur[0];
			int curDist = cur[1];
			
			if(curDist > distTo[curV]) continue;
			if(curV == start) break;
			
			for(int[] edge : arrList[curV]) {
				int next = edge[0];
				int nextDist = curDist + edge[1];
				
				if(nextDist < distTo[next]) {
					distTo[next] = nextDist;
					pq.offer(new int[] {next, nextDist});
				}
			}
			
		}
		
		
		return distFrom[X] + distTo[start];
	}

}
