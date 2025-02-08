import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for (int[] cmd:commands){
            // copyOfRange(array, start, end) : array[start:end], start <= i < end
            int[] result = Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]); 
            Arrays.sort(result);
            answer.add(result[cmd[2] - 1]);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}