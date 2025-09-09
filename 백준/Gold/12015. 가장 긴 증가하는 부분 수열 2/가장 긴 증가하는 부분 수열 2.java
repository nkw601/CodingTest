import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer> sequence;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		sequence = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());			
			int idx = Collections.binarySearch(sequence, num);
			
			if(idx < 0) idx = -(idx + 1);
			
			if(idx == sequence.size()) {
				sequence.add(num);
			} else {
				sequence.set(idx, num);
			}
			
		}
		System.out.println(sequence.size());
	}

}
