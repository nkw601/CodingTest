import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] countries;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		// 초기화
		countries = new int[N];
		for(int i = 0; i < N; i++) {
			countries[i] = i;
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 1이면 연결 아니면 안연결
			for(int j = 0; j < N; j++) {
				if(st.nextToken().equals("0")) continue;
				union(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int cur = Integer.parseInt(st.nextToken()) - 1;
		while(st.hasMoreTokens()) {
			int dest = Integer.parseInt(st.nextToken()) - 1;
			
			if(find(cur) != find(dest)) {
				System.out.println("NO");
				return;
			}
			
			cur = dest;
		}
		System.out.println("YES");
	}
	
	private static int find(int a) {
		if(countries[a] == a) return a;
		else return countries[a] = find(countries[a]);
	}
	
	private static void union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		
		if(pA == pB) return;
		
		countries[pA] = pB;
	}

}
