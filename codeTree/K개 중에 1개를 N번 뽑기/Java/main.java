import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int K, N;
	private static int[] numbers;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		makePermu(0);
	}
	
	private static void makePermu(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(numbers[i] +  " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= K; i++) {
			numbers[cnt] = i; 
			makePermu(cnt + 1);
		}
		
	}
}
