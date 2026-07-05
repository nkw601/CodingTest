import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        Deque<Integer> a = new ArrayDeque<>();
        Deque<Integer> b = new ArrayDeque<>();

        for (int n : A) a.offer(n);
        for (int n : B) b.offer(n);

        int answer = 0;

        while (!a.isEmpty() && !b.isEmpty()) {
            if (b.peek() > a.peek()) {
                answer++;
                a.poll();
                b.poll();
            } else {
                b.poll(); // 이길 수 없으면 B의 가장 작은 수 버림
            }
        }

        return answer;
    }
}