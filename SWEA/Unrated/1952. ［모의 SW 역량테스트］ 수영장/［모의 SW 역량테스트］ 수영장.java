import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dp, useFreq;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			dp = new int[13];
			useFreq = new int[13];
			int day, month, quarter, year;
			st = new StringTokenizer(br.readLine());
			
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			quarter = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= 12; i++) {
				useFreq[i] = Integer.parseInt(st.nextToken());
			}
			
			dp[1] = Math.min(Math.min(month, quarter), useFreq[1] * day); 
			dp[2] = Math.min(Math.min(month, quarter), useFreq[2] * day) + dp[1];
			dp[3] = Math.min(Math.min(month, quarter), useFreq[3] * day) + dp[2];
			
			for(int i = 3; i <= 12; i++) {
				int min =  Math.min(month, useFreq[i] * day);
				min = Math.min(dp[i - 3] + quarter, dp[i - 1] + min);
				dp[i] = min;
			}
			
			sb.append("#").append(tc).append(" ").append(Math.min(year, dp[12])).append('\n');
		}
		
		System.out.println(sb);
	}

}
