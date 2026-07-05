class Solution {
    public int[] solution(int n, int s) {
        // 집합의 합: s
        // 집합의 원소 개수: n

        // 1. n > s면 최고의 집합 존재 X
        if (n > s) {
            return new int[]{-1};
        }

        // 2. 곱이 최대가 되려면 최대한 균등하게 분배
        // s / n : 기본값
        int fir = s / n;
        int num = s % n;

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = fir;
        }

        for (int i = 0; i < num; i++) {
            answer[n - 1 - i]++;
        }

        return answer;
    }
}