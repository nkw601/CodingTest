import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static long minWeight;
	static int[][] edges;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			// 초기화
			minWeight = 0;
	
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			// from, to, weight 저장
			edges = new int[E + 1][3];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				// 0 idx 시작이므로
				edges[i][0] = Integer.parseInt(st.nextToken()) - 1;
				edges[i][1] = Integer.parseInt(st.nextToken()) - 1;
				edges[i][2] = Integer.parseInt(st.nextToken());
			}
			
			// 정렬 -> 기준: weight
			Arrays.sort(edges, (o1, o2) -> Integer.compare(o1[2], o2[2]));
			
			// union - 초기화
			make(V);
			
			int cnt = 0;
			// union
			for(int[] edge: edges) {
				// 종결 조건
				if(cnt == V - 1) break;
				
				// 합집합 가능하다면
				if(union(edge[0], edge[1])) {
					cnt++;
					minWeight+=edge[2];
				}
			}
			
			sb.append("#").append(tc).append(" ").append(minWeight).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void make(int V) {
		parents = new int[V];
		for(int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		
		if(pA == pB) return false;
		
		parents[pA] = pB;		
		return true;
	}
}
