import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        boolean answer = true;
        
        for (String phone:phone_book){
            map.put(phone, 0);
        }
        
        for (String phone:phone_book){
            for(int i = 1; i < phone.length(); i++){
                String num = phone.substring(0, i);
                if(map.containsKey(num)) {return false;}
            }
        }
        
        return answer;
    }
}