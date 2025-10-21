import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static Node[] computers;
	static boolean[] visited;
	
	static class Node {
		int data;
		ArrayList<Node> children;
		
		Node(){}
		Node(int data) {
			this.data = data;
			children = new ArrayList<Node>();
		}
		
		public void insert(Node node) {
			children.add(node);
		}
		
		
		public int getData() {
			return data;
		}
		public ArrayList<Node> getChildren() {
			return children;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 노드의 수
		int n = Integer.parseInt(st.nextToken());
		// 신뢰하는 컴퓨터의 수
		int m = Integer.parseInt(st.nextToken());
		
		// 컴퓨터 번호: 1 ~ n
		computers = new Node[n + 1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 컴퓨터 번호 받아오기
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			Node comA = computers[a];
			Node comB = computers[b];
			
			// null 체크
			if(comA == null) { 
				comA = new Node(a);
				computers[a] = comA;
			}
			if(comB == null) {
				comB = new Node(b);
				computers[b] = comB;
			}
			
			// 믿자!!
			comB.insert(comA);
		}
		
		// 결과 배열과 visited 배열 생성
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int maxVal = 0;
		for(int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			int cnt = dfs(i, 0);
			if(maxVal == cnt) {
				result.add(i);
			} else if(maxVal < cnt) {
				result.clear();
				result.add(i);
				maxVal = cnt;
			}
		}
		
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
	public static int dfs(int start, int cnt) {
		visited[start] = true;
		Node cur = computers[start];
		if (computers[start] == null) return cnt;

		cnt++;
		// cur을 신뢰하는 사이
		for(Node trust: cur.getChildren()) {
			// 방문 안했으면
			if(visited[trust.getData()] == false) {
				cnt = dfs(trust.getData(), cnt);
			}
		}
		return cnt;
	}
}
