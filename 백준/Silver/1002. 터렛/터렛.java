import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dx = x1 - x2;
            int dy = y1 - y2;

            int distSq = dx * dx + dy * dy;
            int sumSq = (r1 + r2) * (r1 + r2);
            int diffSq = (r1 - r2) * (r1 - r2);

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1).append('\n');
            } else if (distSq > sumSq || distSq < diffSq) {
                sb.append(0).append('\n');
            } else if (distSq == sumSq || distSq == diffSq) {
                sb.append(1).append('\n');
            } else {
                sb.append(2).append('\n');
            }
        }

        System.out.print(sb);
    }
}