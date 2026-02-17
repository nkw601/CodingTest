import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String init = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        // 초기 문자열 → 왼쪽 스택
        for (char c : init.toCharArray()) {
            left.push(c);
        }

        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();

            switch (cmd.charAt(0)) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;

                case 'D':
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;

                case 'B':
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;

                case 'P':
                    left.push(cmd.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        while (!right.isEmpty()) sb.append(right.pop());

        System.out.println(sb);
    }
}