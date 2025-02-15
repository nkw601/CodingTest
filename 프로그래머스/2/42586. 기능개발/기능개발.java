import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        // 큐에 걸리는 날짜 넣기
        for (int i = 0; i < progresses.length; i++){
            // ceil(올림), (100-현재 진도율) / 속도
            que.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        while(!que.isEmpty()){
            // 첫 번째 배포일: 첫 번째 기능 완료 날짜
            int day = que.poll();
            int cnt = 1;
            
            // que가 비어있지 않고, 개발 완료 날짜가 day보다 빠른 경우
            while(!que.isEmpty() && que.peek() <= day){
                cnt++;
                que.poll(); // 꺼내기
            }
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}