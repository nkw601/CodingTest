import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int money;

            if (a == b && b == c) {
                money = 10000 + a * 1000;
            } else if (a == b || a == c) {
                money = 1000 + a * 100;
            } else if (b == c) {
                money = 1000 + b * 100;
            } else {
                int mx = Math.max(a, Math.max(b, c));
                money = mx * 100;
            }

            ans = Math.max(ans, money);
        }

        System.out.println(ans);
    }
}