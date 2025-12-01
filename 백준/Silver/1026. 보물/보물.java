import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] numA = new int[N];
        int[] numB = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numA);
        Arrays.sort(numB);

        int s = 0;
        for(int i = 0; i < N; i++){
            s += numA[i] * numB[N - i - 1];
        }

        System.out.println(s);
    }
}