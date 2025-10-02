import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		int[] chars = new int[26];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		s = s.toLowerCase();
		for(int i = 0; i < s.length(); i++) {
			chars[s.charAt(i) - 'a']++;
		}
		
		
		int max = 0;
		char maxAlpha = 'A';
		for(int i = 0; i < 26; i++) {
			if(chars[i] > max) {
				max = chars[i];
				maxAlpha = (char) ('A' + i);
			} else if(chars[i] == max) {
				maxAlpha = '?';
			}
		}
		
		System.out.println(maxAlpha);
	}

}
