import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int chang = 100;
        int sang = 100;

        for(int i = 0; i  < n; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if(c > s) sang -= c;
            else if(c == s) continue;
            else chang -= s;
        }
        System.out.println(chang + "\n" + sang);
    }
}