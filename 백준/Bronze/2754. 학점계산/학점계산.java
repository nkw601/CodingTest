import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		if(s.length() == 1) {
			System.out.println(0.0);
			return;
		}
		
		double sco = 0;
		
		if(s.charAt(0) == 'A') {
			sco += 4.3;
		} else if(s.charAt(0) == 'B') {
			sco += 3.3;
		} else if(s.charAt(0) == 'C') {
			sco += 2.3;
		} else if(s.charAt(0) == 'D') {
			sco += 1.3;
		}
		
		if(s.charAt(1) == '-') {
			sco -= 0.6;
		} else if(s.charAt(1) == '0') {
			sco -= 0.3;
		}
		
		System.out.println(String.format("%.1f", sco));
	}

}
