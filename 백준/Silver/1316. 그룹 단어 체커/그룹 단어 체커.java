import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine().toLowerCase();
			char[] alphas = new char[26];
			boolean isGroup = true;
			for(int s = 0; s < str.length(); s++) {
				char cur = str.charAt(s);
				if(alphas[cur - 'a'] != 0) {
					if(cur != str.charAt(s - 1)) {
						isGroup = false;
						break;
					}
				} else {
					alphas[cur - 'a']++;
				}
			}
			
			if(isGroup) cnt++;
		}
		
		System.out.println(cnt);
	}

}
