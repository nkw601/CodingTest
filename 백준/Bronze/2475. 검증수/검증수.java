import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cert = 0;

        for(int i = 0; i < 5; i++){
            cert += Math.pow(Integer.parseInt(st.nextToken()), 2) % 10;
        }
        System.out.println(cert % 10);
    }
}