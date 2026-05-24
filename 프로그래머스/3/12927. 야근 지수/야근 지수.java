import java.util.*;

class Solution {
    PriorityQueue<Integer> pq;
    public long solution(int n, int[] works) {
        pq = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        for (int work : works) {
            pq.offer(work);
            sum += work;
        }

        // 전부 처리 가능
        if (sum <= n) {
            return 0;
        }

        // n시간 동안 일 처리: 작업량 가장 많은거
        while (n-- > 0) {
            int max = pq.poll();
            pq.offer(max - 1);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();

            answer += (long) work * work;
        }

        return answer;
    }
}