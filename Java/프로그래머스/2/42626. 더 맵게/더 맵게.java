import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int sco:scoville) {
            que.add(sco);
        }
        
        // que에 원소가 2개 이하일 경우 새 지수 계산 불가능
        while(que.peek() < K && que.size() >= 2) {
            int newFood = que.poll() + (que.poll() * 2);
            que.add(newFood);
            answer += 1;    
        }
        
        if (que.peek() < K) {return -1;}
        
        return answer;
    }
}