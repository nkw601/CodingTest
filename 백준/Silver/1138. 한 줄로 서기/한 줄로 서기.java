import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] tallerCount = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tallerCount[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];
        Arrays.fill(result, 0);

        for (int height = 1; height <= N; height++) {
            int count = tallerCount[height];

            for (int i = 0; i < N; i++) {
                if (result[i] == 0) {
                    if (count == 0) {
                        result[i] = height;
                        break;
                    }
                    count--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}