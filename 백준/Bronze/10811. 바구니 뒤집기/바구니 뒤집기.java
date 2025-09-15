import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int[] books;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N, M;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		books = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			books[i] = i;
		}
		
		for(int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int start, end;
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			reverse(start, end);
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(books[i]).append(" ");
		}
		
		System.out.println(sb);
	}

	private static void reverse(int start, int end) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = start; i <= end; i++) {
			stack.add(books[i]);
		}
		
		for(int i = start; i <= end; i++) {
			books[i] = stack.pop();
		}
	}

}

/*
 * 1번 ~ N번 책
 * 
 * M번에 걸쳐 구간 선택, 구간의 책 순서를 뒤집음
 * 
 * i, j -> i~j책 뒤집뒤집
 * 
 * 입력:
 * N M
 * M: i j
 * 1~N번 책 최종 배치 공백 구분 출력
 * 
 * 스택 써서 뒤집으면 되지 않을까...
 */
