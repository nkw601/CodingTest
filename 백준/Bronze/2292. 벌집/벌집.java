import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int curMax = 1;
		int shell = 0;
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		while(N >= curMax) {
			curMax += 6 * (shell++);
			if(curMax >= N) break;
		}
		System.out.println(shell);
		// 1
		// 2 ~ 1+6 2 ~ 7
		// 1+6 ~ 1+6+6*2 8 ~ 19
		// 20 ~ 38
	}

}
