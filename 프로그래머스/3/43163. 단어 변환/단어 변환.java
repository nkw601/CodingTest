import java.util.*;

class Solution {
    
    boolean[] visited;
    Queue<String> q;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        q = new LinkedList<>();
        
        q.offer(begin);

        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                String now = q.poll();
                if (now.equals(target)) {
                    return count;
                }

                for (int i = 0; i < words.length; i++) {
                    if (!visited[i] && canChange(now, words[i])) {
                        visited[i] = true;
                        q.offer(words[i]);
                    }
                }
            }
            count++;
        }

        return 0;
    }

    public boolean canChange(String a, String b) {
        int cnt = 0;

        for (int i = 0; i < a.length(); i++) {
            // 다른 개수 체크
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }

        return cnt == 1;
    }
}