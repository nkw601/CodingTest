import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    private int minIntensity = Integer.MAX_VALUE;
	private ArrayList<int[]>[] adjList;
	private int[] intense;
	private boolean[] isGate, isSummit;
	
	public int[] solution(int n, int[][] paths, int[] gates, int[] summits){
        int[] answer = new int[2];
        adjList = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        intense = new int[n + 1];
        Arrays.fill(intense, Integer.MAX_VALUE);
        isGate   = new boolean[n + 1];
        isSummit = new boolean[n + 1];
        for (int g : gates)   isGate[g] = true;
        for (int s : summits) isSummit[s] = true;
        
        makeAdjList(paths);
        
        dijkstra(n, paths, gates, summits);
        
        int minInt = Integer.MAX_VALUE;
        int minPeek = 0;
        Arrays.sort(summits);
        for(int s : summits){
            if(minInt > intense[s]){
                minPeek = s;
                minInt = intense[s];
            }
        }
        answer[0] = minPeek;
        answer[1] = minInt;
        
        return answer;
    }
	
	private void makeAdjList(int[][] paths) {
		for(int[] path: paths) {
			// [from, to, dist]
			int from = path[0];
			int to = path[1];
			int dist = path[2];
			adjList[from].add(new int[] {to, dist});
			adjList[to].add(new int[] {from, dist});
		}
	}

	private void dijkstra(int n, int[][] paths, int[] gates, int[] summits) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		
		// 출발지 넣기
		for(int gate : gates) {
			pq.offer(new int[] {gate, 0}); // 현위치, intensity
			intense[gate] = 0;
		}
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curPoint = cur[0];
			int curInten = cur[1];
			
			// min보다 inten 크면 볼 필요 없음
			if(curInten > minIntensity) continue;
			if(curInten > intense[curPoint]) continue;

			// 봉우리면 더 이상 볼 필요 없음(도착한 순간 -> 돌아오는 길도 정해짐)
			if(isSummit[curPoint]) {
				if (curInten < minIntensity) minIntensity = curInten;
                continue;
			}
			
			// 연결된 곳마다
			for(int[] next: adjList[curPoint]) {
				int nextPoint = next[0];
				
				// 다음 inten: 다음 장소까지 가는 가장 긴 가중치
				int nextInten = Math.max(next[1], curInten);
				
				// 출발지 갈 필요 없음
				if(isGate[nextPoint]) continue;

				// 여기까지 덜 힘들게 올 수 있으면
				if(intense[nextPoint] > nextInten) {
					// 갱신하고
					intense[nextPoint] = nextInten;
					// 넣고
					pq.offer(new int[] {nextPoint, nextInten});
				}
			}
			
		}
	}
}
