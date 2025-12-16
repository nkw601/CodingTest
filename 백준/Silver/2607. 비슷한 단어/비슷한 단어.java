import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] first, diff;
    private static int firstLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        first = new int[26];
        diff = new int[26];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (i == 0) {
                firstLen = word.length();
                makeWord(word, first);
            } else {
                Arrays.fill(diff, 0);
                makeWord(word, diff);
                if (canChange(word.length())) cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean canChange(int len) {
        int diffSum = 0;
        for (int i = 0; i < 26; i++) {
            diffSum += Math.abs(first[i] - diff[i]);
        }

        int lenDiff = Math.abs(firstLen - len);

        if (lenDiff == 0) {
            return diffSum == 0 || diffSum == 2;  // 같음 or 한 글자 교체
        } else if (lenDiff == 1) {
            return diffSum == 1;                  // 한 글자 추가/삭제
        }
        return false;
    }

    private static void makeWord(String word, int[] arr) {
        for (char c : word.toCharArray()) {
            arr[c - 'A']++;
        }
    }
}