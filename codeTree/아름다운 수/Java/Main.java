import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int N, beauty = 0;
	private static int[] number;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		
		makeNum(0);
		System.out.println(beauty);
	}
	
	static private void makeNum(int cnt) {
		if(cnt == N) {
			isBeautiful();
			return;
		}
		
		for(int i = 1; i <= 4; i++) {
			number[cnt] = i;
			makeNum(cnt + 1);
		}
	}
	
	static private void isBeautiful() {
		int twoCnt = 0;
		int threeCnt = 0;
		int fourCnt = 0;

		for(int cur : number) {			
			switch (cur) {
			case 1:
				if(twoCnt != 0 || threeCnt != 0 || fourCnt != 0) return;
				break;
			case 2:
				if(threeCnt != 0 || fourCnt != 0) return;
				if(++twoCnt == 2) twoCnt = 0;
				break;
			case 3:
				if(twoCnt != 0 || fourCnt != 0) return;
				if(++threeCnt == 3) threeCnt = 0;
				break;
			case 4:
				if(threeCnt != 0 || twoCnt != 0) return;
				if(++fourCnt == 4) fourCnt = 0;
				break;
			}
		}
		if(twoCnt == 0 && threeCnt == 0 && fourCnt == 0) {
			beauty++;
		}
		
	}
}

/*
 * 1 ~ 4 이하의 정수, 해당 숫자만큼 연달아 같은 숫자가 나오는 수를 찾기
 * 조합할 수 있는 수만큼 순열하는 경우의 수
 * N자리 아름다운 수
 * 아니다 N자리면
 * 걍 만들 수 있는 모든 순열 만들고 아름다운지 확인
 */
