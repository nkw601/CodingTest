import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> members = new HashMap<String, Integer>();
        
        // HashMap에 참여자 추가, int는 동명이인 체크용
        for (String name:participant) {
            members.put(name, members.getOrDefault(name, 0) + 1);
        }
        
        // HashMap 완주자 숫자 1 빼기
        for (String name:completion) {
            members.replace(name, members.getOrDefault(name, 0) - 1);
        }
        
        for (String name : members.keySet()) {
            if (members.get(name) != 0) {
                return name;
    }
}
        
        return answer;
    }
}