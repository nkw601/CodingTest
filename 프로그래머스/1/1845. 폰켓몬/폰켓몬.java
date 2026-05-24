import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        // 중복 제거 -> set에 넣기
        HashSet<Integer> set = new HashSet<>();
        
        for (int n : nums) { set.add(n); }
        
        int maxNum = nums.length / 2;
        int setSize = set.size();
        return  setSize < maxNum ? setSize : maxNum ;
    }
}