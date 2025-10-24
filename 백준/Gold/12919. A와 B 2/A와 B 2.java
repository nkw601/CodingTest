import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        boolean flag = dfs(s, t);
        System.out.println(flag ? 1 : 0);
    }

    private static boolean dfs(String s, String t) {
        char[] tc = t.toCharArray();
        return dfs(s, tc, 0, t.length() - 1, false);
    }

    private static boolean dfs(String s, char[] t, int start, int last, boolean rev) {
        int curLen = last - start + 1;
        if (curLen < s.length()) return false;

        if (curLen == s.length()) {
            for (int i = 0; i < curLen; i++) {
                char c = rev ? t[last - i] : t[start + i];
                if (c != s.charAt(i)) return false;
            }
            return true;
        }

        boolean ok = false;

        if (!rev) {
            if (t[last] == 'A') {
                ok |= dfs(s, t, start, last - 1, false);
                if (ok) return true;
            }
            if (t[start] == 'B') {
                ok |= dfs(s, t, start + 1, last, true);
            }
        } else {
            if (t[start] == 'A') {
                ok |= dfs(s, t, start + 1, last, true);
                if (ok) return true;
            }
            if (t[last] == 'B') {
                ok |= dfs(s, t, start, last - 1, false);
            }
        }
        return ok;
    }
}

/*
 * 가능한 연산:
 * 1) 문자열 뒤에 A 추가
 * 2) 문자열 뒤에 B 추가하고 문자열 뒤집기
 * 
 * S를 T로 만들 수 있는지 확인
 * 
 * -> T에서 S를 만들 수 있는지 확인
 */