import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stk = new Stack<>();
        for (char p:s.toCharArray()){
            if(p == '('){
                stk.push(p);
            }
            else{
                if(!stk.isEmpty()) { stk.pop(); }
                else { return false; }
            }
        }
                
        return stk.isEmpty();
    }
}