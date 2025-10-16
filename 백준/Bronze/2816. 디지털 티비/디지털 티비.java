import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		// 채널 수
		int N = Integer.parseInt(br.readLine());
		// 채널 이름
		String[] channels = new String[N];
		for(int i = 0; i < N; i++) {
			channels[i] = br.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 어떻게 바꾸지??
		// 1. KBS1 위로 쭉 올리기
		int cursor = 0;
		
		// idx = 0 ~ fir까지 화살표 내림
		while(!channels[cursor].equals("KBS1")) {
			sb.append(1);
			cursor++;
		}
		
		// 올리기
		while(cursor != 0) {
			swap(channels, cursor, cursor-1);
			cursor -= 1;
			sb.append(4);
		}
		
		
//		// 2. KBS2 위로 쭉 올리기
//		// idx = 0 ~ fir까지 화살표 내림
		while(!channels[cursor].equals("KBS2")) {
			sb.append(1);
			cursor++;
		}
//		// 올리기
		while(cursor != 1) {
			cursor -= 1;
			sb.append(4);
		}
//		
		
		System.out.println(sb);
	}
	
	private static void swap(String[] channels, int a, int b) {
		String temp = channels[a];
		channels[a] = channels[b];
		channels[b] = temp;
	}

}