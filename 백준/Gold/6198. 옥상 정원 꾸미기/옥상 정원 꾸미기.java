import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		long canSee = 0;
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < N; i++) {
			int hei = Integer.parseInt(br.readLine());
			
			while(!st.isEmpty()) {
				if(st.peek() <= hei) st.pop();
				else break;
			}
			canSee += st.size();
			st.add(hei);
		}
		
		System.out.println(canSee);
	}
}