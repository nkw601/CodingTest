import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int D = Integer.parseInt(br.readLine());

        int total = A * 3600 + B * 60 + C;
        total += D;
        total %= 24 * 3600;

        int hour = total / 3600;
        total %= 3600;
        int min = total / 60;
        int sec = total % 60;

        System.out.println(hour + " " + min + " " + sec);
    }
}