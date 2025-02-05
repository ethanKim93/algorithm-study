class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap(){};

        for(int i = 0 ; i < nums.length  ; i ++){
            int remain = target - nums[i];
            if(numsMap.containsKey(remain)){
                return new int[]{i,numsMap.get(remain)};
            }
            numsMap.put(nums[i],i);
        }
        return null;
    }
}