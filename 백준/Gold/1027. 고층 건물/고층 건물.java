import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] h = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            h[i] = Long.parseLong(st.nextToken());
        }

        int[] visible = new int[N];

        for (int i = 0; i < N; i++) {
            double maxSlope = -1e18;

            for (int j = i + 1; j < N; j++) {
                double slope = (double)(h[j] - h[i]) / (j - i);

                if (slope > maxSlope) {
                    maxSlope = slope;
                    visible[i]++;
                    visible[j]++;
                }
            }
        }

        int answer = 0;
        for (int v : visible) {
            answer = Math.max(answer, v);
        }

        System.out.println(answer);
    }
}