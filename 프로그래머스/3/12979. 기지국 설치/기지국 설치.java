class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2 * w + 1;

        int start = 1; // 전파 안닿은 구간 시작

        for (int station : stations) {
            int left = station - w;
            int right = station + w;

            if (start < left) {
                int length = left - start;
                answer += (length + cover - 1) / cover;
            }

            start = right + 1;
        }

        if (start <= n) {
            int length = n - start + 1;
            answer += (length + cover - 1) / cover;
        }

        return answer;
    }
}