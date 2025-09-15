
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static String[] cards;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cards = new String[(int) N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				cards[i] = st.nextToken();
			}
			
			Stack<String> st1 = new Stack<>();
			Stack<String> st2 = new Stack<>();
			
			int half = (N + 1) / 2;
			for(int i = 0; i < N; i++) {
				if(i < half) st1.add(cards[i]);
				else st2.add(cards[i]);
			}
			
			for(int i = N - 1; i >= 0; i--) {
				if(i % 2 == 0) cards[i] = st1.pop();
				else cards[i] = st2.pop();
			}
			
			sb.append('#').append(tc).append(' ');
			for(int i = 0; i < N; i++) {
				sb.append(cards[i]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
