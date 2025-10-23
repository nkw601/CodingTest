import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int cnt = 0;
		int len = s.length();
		int idx = len - 1;
		// =, -의 수
		// lj, nj의 수		
		while(idx >= 0) {
			char c = s.charAt(idx);
			if(c == '=') {
				if(idx - 2 >= 0 && s.charAt(idx - 1) == 'z' && s.charAt(idx - 2) == 'd') {
					idx-=2;
				} else {
					idx--;
				}
			} else if(c == '-') {
				idx--;
			} else if(c == 'j') {
				if(idx - 1 >= 0 && (s.charAt(idx - 1) == 'l' || s.charAt(idx - 1) == 'n')) {
					idx--;
				}
			}				
			idx--;
			cnt++;
			
		}
		System.out.println(cnt);
	}
}
