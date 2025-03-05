import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Map<Integer,Integer> pocketMap = new HashMap<>();
        
        for(int num : nums){
            int count = pocketMap.getOrDefault(num,0);
            count += 1;
            pocketMap.put(num,count);
        }
        
        int answer = Math.min(nums.length / 2,pocketMap.size());
        
        return answer;
    }
}