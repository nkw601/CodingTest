import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashSet<String> wordSet = new HashSet<>();

        // 단어 입력
        for(int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }

        int size = wordSet.size();
        String[] words = new String[size];

        int cnt = 0;
        for(String w : wordSet) {
            words[cnt++] = w;
        }

        Arrays.sort(words, (s1, s2) ->  {
            if(s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return Integer.compare(s1.length(), s2.length());
        });


        for(int i = 0; i < size; i++) {
            sb.append(words[i]).append("\n");
        }

        System.out.print(sb);
    }
}
