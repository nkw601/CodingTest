import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1; // 최소 거리
        int right = house[N - 1] - house[0]; // 최대 거리
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canInstall(mid)) {
                answer = mid;      // 일단 가능하므로 저장
                left = mid + 1;    // 더 큰 거리 시도
            } else {
                right = mid - 1;   // 거리 줄이기
            }
        }

        System.out.println(answer);
    }

    static boolean canInstall(int distance) {
        int count = 1; // 첫 집 설치
        int lastInstalled = house[0];

        for (int i = 1; i < N; i++) {
            if (house[i] - lastInstalled >= distance) {
                count++;
                lastInstalled = house[i];
            }
        }

        return count >= C;
    }
}