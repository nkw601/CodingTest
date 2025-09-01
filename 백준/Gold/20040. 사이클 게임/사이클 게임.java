import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parents;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 초기화
		parents = new int[n];
		make();
		
		int cnt;
		boolean success = true;
		// 총 m개의 간선 존재
		for(cnt = 0; cnt < m; cnt++) {
			// 실패하는 즉시 중단
			if(!success) break;
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			success = union(n1, n2);
		}
//		System.out.println(cnt);
		System.out.println(success? 0 : cnt);
	}
	
	// 자기 자신을 부모로 갖도록 초기상태 설정
	static void make() {
		for(int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int idx) {
		if(parents[idx] == idx) return idx;
		else return parents[idx] = find(parents[idx]); // 경로 압축
	}
	
	static boolean union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		// 사이클 발생 시 중단
		if(p1 == p2) return false;
		
		if(p1 < p2)parents[p1] = p2;
		else parents[p2] = p1;
		
		return true;
	}
}
