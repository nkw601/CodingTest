import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n1 = Long.parseLong(st.nextToken());
        long n2 = Long.parseLong(st.nextToken());

        if(n1 == n2) {
            System.out.println(0);
            System.out.println();
            return;
        }

        long a = Math.min(n1, n2);
        long b = Math.max(n1, n2);

        sb.append(b - a - 1).append('\n');
        for(long i = a + 1; i < b; i++){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}