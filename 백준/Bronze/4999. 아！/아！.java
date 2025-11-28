import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String jh = br.readLine();
		int jhCnt = 0;
		
		for(char c : jh.toCharArray()) {
			if(c == 'a') jhCnt++;
		}
		
		String doc = br.readLine();
		int docCnt = 0;
		for(char c : doc.toCharArray()) {
			if(c == 'a') docCnt++;
		}
		
		if (jhCnt >= docCnt) System.out.println("go");
		else System.out.println("no");
	}
}
