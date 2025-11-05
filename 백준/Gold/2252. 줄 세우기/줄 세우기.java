import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

import java.io.IOException;

public class Main {
	private static int N, M;
	private static ArrayList<Integer>[] students;
	private static int[] order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		students = new ArrayList[N + 1];
		order = new int[N + 1];
		Arrays.fill(order, 0);
		for(int i = 1; i <= N; i++) {
			students[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int shorter = Integer.parseInt(st.nextToken()); // 작은 애가 더 앞
			int taller = Integer.parseInt(st.nextToken());
			
			students[shorter].add(taller);
			order[taller]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			if(order[i] == 0) q.offer(i);
		}
		 
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for(int next : students[cur]) {
				order[next]--;
				if(order[next] == 0) q.offer(next);
			}
		}
		
		System.out.println(sb);
	}

}