import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, minDiff = Integer.MAX_VALUE;
	private static boolean[] selected;
	private static int[][] S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		selected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 팀 두 개로 나눔
		// 2. 능력치 계산
		makeTeam(0, 0);
		System.out.println(minDiff);
	}
	private static void makeTeam(int idx, int cnt) {
		if(cnt == N / 2) {
			calcScore();
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				makeTeam(i + 1, cnt + 1);
				selected[i] = false;
			}
		}
		
	}
	private static void calcScore() {
		int s1 = 0;
		int s2 = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				if(selected[i] && selected[j]) {
					s1 += (S[i][j] + S[j][i]);
				} else if(!selected[i] && !selected[j]) {
					s2 += (S[i][j] + S[j][i]);
				}
			}
		}
		
		minDiff = Math.min(minDiff, Math.abs(s1 - s2));
	}

}
