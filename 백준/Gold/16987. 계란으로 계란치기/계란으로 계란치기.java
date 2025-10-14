import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, maxBreak;
	private static int[][] eggs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		eggs = new int[N][2];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i][0] = Integer.parseInt(st.nextToken()); // 내구도
			eggs[i][1] = Integer.parseInt(st.nextToken()); // 무게
		}
		maxBreak = 0;
		breakEgg(0, 0);
		System.out.println(maxBreak);
	}


	private static void breakEgg(int cur, int breakCnt) {
		// 종결조건
		if(cur == N) {
			maxBreak = Math.max(breakCnt, maxBreak);
			return;
		};

		// if(breakCnt + (N - cur) * 2 < maxBreak) return; // 가지치기
		
		if(eggs[cur][0] <= 0) {
			breakEgg(cur + 1, breakCnt); // 나 깨져있으면 아무것도 못함...
		} else {
			// 0 ~ N번 달걀 깨기
			boolean isBreak = false;
			for(int i = 0; i < N; i++) {
				if(i == cur) continue; // 나로 나 깨기 불가능
				if(eggs[i][0] <= 0) continue; // 이미 깨진애 깰 수 없음
				
				// 깨러가자~
				isBreak = true;
				// 달걀 깨서 다음으로 보내기
				eggs[i][0] -= eggs[cur][1];
				eggs[cur][0] -= eggs[i][1];
				
				int cnt = 0;
				if(eggs[i][0] <= 0) cnt++;
				if(eggs[cur][0] <= 0) cnt++;
				
				breakEgg(cur + 1, breakCnt + cnt);
				// 원상복구
				eggs[i][0] += eggs[cur][1];
				eggs[cur][0] += eggs[i][1];
			}
			if(!isBreak) breakEgg(cur + 1, breakCnt);
		}
	}
}
/*
 * 계란으로 계란 (바위) 치기!!
 * 내구도는 상대 계란의 무게만큼 깎이고, 0 이하면 깨짐
 * 일렬로 왼쪽부터 하나씩 침...
 * 그리고 오른쪽으로 하나씪 오면서 또 침
 * 
 * 뭔가 최적화 있나
 * 일단 냅다 깨보자
 * 아니 뭐가 문제야???
 */
