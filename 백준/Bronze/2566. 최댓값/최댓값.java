import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int maxR = 1, maxC = 1;

        for (int r = 1; r <= 9; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= 9; c++) {
                int x = Integer.parseInt(st.nextToken());
                if (x > max) {
                    max = x;
                    maxR = r;
                    maxC = c;
                }
            }
        }

        System.out.println(max);
        System.out.println(maxR + " " + maxC);
    }
}