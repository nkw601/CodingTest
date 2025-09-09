import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] numbers;
	static ArrayList<Integer> lis;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			numbers = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			findLIS();
			int m = lis.size();
			
			sb.append("#").append(tc).append(" ").append(m).append('\n');
		}
		System.out.println(sb);
	}
	
	private static void findLIS() {
		lis = new ArrayList<>();
		// BinSearch로 풀기
		// k 자리 위치에 올 수 있는 가장 작은 값을 C[k]에 저장
		for(int i = 1; i <= N; i++) {
			int num = numbers[i];
			int idx = Collections.binarySearch(lis, num);
			
			if(idx < 0) idx = -(idx + 1);
			
			if(idx == lis.size()) {
				lis.add(num);
			} else {
				lis.set(idx, num);				
			}
		}
	}
}
