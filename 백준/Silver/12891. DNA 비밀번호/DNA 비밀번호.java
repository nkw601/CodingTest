import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int S, P;
	private static String dna;
	private static int[] checknum, minNum;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		dna = br.readLine();
		
		minNum = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			minNum[i] = Integer.parseInt(st.nextToken());
		}
		
		checknum = new int[4];
		int len = dna.length();
		int cnt = 0, start = 0, end = -1;
		
		while(start < len && end < len) {
			if (end - start + 1 < P && end + 1 < len) {
				checknum[findDna(dna.charAt(++end))]++;
			} else {
				if(canMake()) cnt++;
				
				checknum[findDna(dna.charAt(start++))]--;
				if(end + 1 < len) checknum[findDna(dna.charAt(++end))]++;
			    else break;
            }
		}
		
		System.out.println(cnt);
		
	}
	private static int findDna(char c) {
		switch (c) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		}
		
		return -1;
	}
	
	private static boolean canMake() {
		for(int i = 0; i < 4; i++) {
			if(minNum[i] > checknum[i]) return false;
		}
		
		return true;
	}

}
