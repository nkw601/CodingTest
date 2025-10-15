import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int min;
	private static boolean[] buttons;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		buttons = new boolean[10];
		Arrays.fill(buttons, true);
		
		min = Math.abs(N - 100);
		
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				buttons[Integer.parseInt(st.nextToken())] = false;
			}			
		}
		// 0 ~ n까지 몇 번 눌러서 할 수 있나??
		for (int n = 0; n <= 1000000; n++) {
            int len = canType(n);
            if (len == -1) continue; // 고장난 버튼이 포함되면 스킵
            int press = len + Math.abs(N - n);
            if (press < min) min = press;
        }
		
		System.out.println(min);
		
	}

	private static int canType(int n) {
		if (n == 0) return buttons[0] ? 1 : -1; // 0 처리

        int len = 0; // 누른 횟수
        while (n > 0) {
            int d = n % 10; // 이번에 누를 버튼
            if (!buttons[d]) return -1; // 고장났으면 못누름
            len++; // 누르기
            n /= 10; // 다음 자리
        }
        return len;
	}
}