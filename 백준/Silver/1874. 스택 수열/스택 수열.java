import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int[] nums = new int[n];
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		// 스택 채우기
		int cnt = 0;
		while(cnt < nums[0]) {
			st.add(++cnt);
			sb.append("+").append('\n');
			
		}
		
		for(int i = 0; i < n; i++) {
			// 1. peek가 출력해야하는 값
			if(!st.isEmpty() && st.peek() == nums[i]) {
				sb.append("-").append('\n');
				st.pop();
			} else if(cnt < nums[i]) { // 2. 더 넣어야 함
				while(cnt < nums[i]) {
					st.add(++cnt);
					sb.append("+").append('\n');
				}
				sb.append("-").append('\n');
				st.pop();
			} else { // 3. 못 만듦
				System.out.println("NO");
				return;
			}
		}
		
		// 뽑고, 넣고
		System.out.println(sb);
	}

}
