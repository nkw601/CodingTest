import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int zeroCnt, oneCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		zeroCnt = oneCnt = 0;
		
		binSearch(0, 0, N);
		System.out.println(zeroCnt);
		System.out.println(oneCnt);
	}
	
	static void binSearch(int sr, int sc, int size) {

		if(check(sr, sc, size)){
			if(map[sr][sc] == 0) zeroCnt++;
			else oneCnt++;
			return;
		}
		
		int newSize = size / 2;
		binSearch(sr, sc, newSize);
		binSearch(sr + newSize, sc, newSize);
		binSearch(sr, sc + newSize, newSize);
		binSearch(sr + newSize, sc + newSize, newSize);
	}
	
	static boolean check(int sr, int sc, int size) {
		int cur = map[sr][sc];
		
		for(int i = sr; i < sr + size; i++) {
			for(int j = sc; j < sc + size; j++) {
				if(map[i][j] != cur) return false;
			}
		}
		
		return true;
	}
}

/*
 * 입력
 * N
 * N: N 개의 정수
 * 0: 정상 타일, 1: 손상 타일
 * 
 * 출력
 * 정상 영역(0)의 개수
 * 손상 영역(1)의 개수
 * 
 * 생각
 * 
 * 
 */
