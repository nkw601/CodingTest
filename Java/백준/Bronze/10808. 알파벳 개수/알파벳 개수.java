import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphas = new int[26];
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'a';
            alphas[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            sb.append(alphas[i]).append(" ");
        }
        System.out.println(sb);
    }
}

