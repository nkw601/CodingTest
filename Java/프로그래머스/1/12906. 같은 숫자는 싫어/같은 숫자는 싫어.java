import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> arrStack = new Stack<>();
        
        for (int num:arr) {
            if(arrStack.isEmpty() || arrStack.peek() != num) {
                arrStack.push(num);
            }
        }
        
        return arrStack.stream().mapToInt(i -> i).toArray();
            }
}