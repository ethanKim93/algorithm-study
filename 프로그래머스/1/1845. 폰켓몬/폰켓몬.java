import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> pockets = new HashSet<>();
        
        for(int num : nums){
           pockets.add(num);
        }
                
        return Math.min(nums.length / 2,pockets.size());
    }
}
