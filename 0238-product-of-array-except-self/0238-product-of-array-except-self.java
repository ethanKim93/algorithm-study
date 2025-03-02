class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] leftValue = new int[nums.length];
        int[] rightValue = new int[nums.length];
        int[] result = new int[nums.length];

        
        leftValue[0] = nums[0];
        rightValue[nums.length-1] = nums[nums.length-1];
           
        for(int i = 1; i <nums.length ; i++ ){
            leftValue[i] = leftValue[i-1] * nums[i];
            rightValue[nums.length - 1 - i] = rightValue[nums.length - i] * nums[nums.length - 1 - i];
        }

        result[0] = rightValue[1];
        result[nums.length - 1] = leftValue[nums.length - 2];

        for(int i = 1; i <nums.length -1 ; i++ ){
           result[i] = leftValue[i-1] * rightValue[i+1]; 
        }

        return result;

    }
}