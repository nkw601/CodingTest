import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, B, min, max, minTime = Integer.MAX_VALUE, maxGround = 0;
	private static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			min = 256;
			max = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] < min) min = map[i][j];
					if(map[i][j] > max) max = map[i][j];
				}
			}
	
			for(int hei = min ; hei <= max; hei++) {
				makeFlat(hei);				
			}
			System.out.println(minTime + " " + maxGround);
	}

	private static void makeFlat(int height) {
		// min ~ max 사이로 모든 칸 만들기?
		// 너무 비효율적인거 아닌가...?
		boolean flag = true;
		int time = 0;
		int canAdd = B;
		
		// 1. 깎아야하는 칸 깎기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > height) {
					int toBreak = map[i][j] - height; 
					canAdd += toBreak;
					time += (toBreak * 2);
				}
			}
		}
		
		// 2. 부족한 칸 채우기
		out:for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] < height) {
					int toBuild = height - map[i][j]; 
					if(toBuild > canAdd) {
						flag = false;
						break out;
					}
					canAdd -= toBuild;
					time += toBuild;
				}
			}
		}
		
		if(flag) {
			if(time <= minTime) {
				minTime = time;
				maxGround = maxGround < height? height : maxGround;
			} 
		}
	}

}
