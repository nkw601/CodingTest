import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int[] mushrooms, scores;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		mushrooms = new int[10];
		scores = new int[10];
		for(int i = 0; i < 10; i++) {
			mushrooms[i] = Integer.parseInt(br.readLine());
		}
		
		scores[0] = mushrooms[0];
		for(int i = 1; i < 10; i++) {
			scores[i] = scores[i - 1] + mushrooms[i];
		}
		
		int closest = 0;
		int diff = 100;
		
		for(int i = 0; i < 10; i++) {
			int curDiff = Math.abs(scores[i] - 100);
			if(curDiff == diff) {
				closest = Math.max(scores[i], closest);
			} else if(curDiff < diff) {
				closest = scores[i];
				diff = curDiff;
			}
		}
		
		System.out.println(closest);
	}

}
