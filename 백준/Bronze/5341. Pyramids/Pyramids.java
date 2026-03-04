import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine().trim());
            if (n == 0) break;

            long sum = (long) n * (n + 1) / 2;  // 1~n 합
            sb.append(sum).append('\n');
        }

        System.out.print(sb.toString());
    }
}