import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] room = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            room[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken()); // 총 감독관
        int C = Integer.parseInt(st.nextToken()); // 부 감독관

        long ans = N; // 한 방에 총 감독관 한 명씩은 들어감

        // 부감독관
        for(int i = 0; i < N; i++) {
            int A = room[i] - B;

            if(A > 0) {
                if (A % C == 0) {
                    ans += A / C;
                } else {
                    ans += (A / C) + 1;
                }
            }
        }

        System.out.println(ans);

    }
}
