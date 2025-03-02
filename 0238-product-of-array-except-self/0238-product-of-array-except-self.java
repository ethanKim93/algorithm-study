class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];
        
        int allValue = 1;
        int zeroCount = 0;

        for(int num : nums){
            if(num == 0){
                zeroCount++;
                continue;
            }    
            allValue *= num;
        }

        for(int i = 0; i <nums.length ; i++ ){
           if(nums[i] == 0 && zeroCount == 1){
                result[i] = allValue;
                continue;
           }
           if(zeroCount > 0){
                continue;
           }
           result[i] = allValue /  nums[i] ; 
        }

        return result;

    }
}