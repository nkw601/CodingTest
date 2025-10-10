import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int G = Integer.parseInt(br.readLine());

		
		int left, right;
		left = 1;
		right = 2;
		int diff = 0;
		while(right <= 100000 && left <= 100000){
			diff = right * right - left * left;
			if(diff == G) {
				sb.append(right).append("\n");
				left++;
				continue;
			}
			
			// diff가 N보다 작을 경우
			if(diff < G) {
				right++;
			} else {
				left++;
			}
			
			
		}
		System.out.println(sb.length() == 0? -1 : sb);
	}
}


// 몸무게
// left - right
// diff: right - left
//  right++ -> -현재right, + 미래 right
// left++ -> +현재left, -미래 left