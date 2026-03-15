import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");

            int idx = -1;

            int pos = 0;
            for (String word : words) {
                char c = Character.toLowerCase(word.charAt(0));
                if (!used[c - 'a']) {
                    used[c - 'a'] = true;
                    idx = pos;
                    break;
                }
                pos += word.length() + 1; // 단어 길이 + 공백
            }
            if (idx == -1) {
                for (int j = 0; j < line.length(); j++) {
                    char ch = line.charAt(j);
                    if (ch == ' ') continue;

                    char lower = Character.toLowerCase(ch);
                    if (!used[lower - 'a']) {
                        used[lower - 'a'] = true;
                        idx = j;
                        break;
                    }
                }
            }
            if (idx == -1) {
                sb.append(line).append('\n');
            } else {
                sb.append(line, 0, idx)
                  .append('[').append(line.charAt(idx)).append(']')
                  .append(line.substring(idx + 1))
                  .append('\n');
            }
        }

        System.out.print(sb);
    }
}