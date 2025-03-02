class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length]; 

        int p = 1; 
        for(int i = 0; i <nums.length ; i++ ){
            result[i] = p;
            p *= nums[i];
        }

        p = 1; 
        for(int i = nums.length -1 ; i >= 0 ; i-- ){
            result[i] *= p;
             p *= nums[i];
        }
        return result;
    }

    /*** 초기 풀이
    public int[] productExceptSelf(int[] nums) {
        
        int[] leftValue = new int[nums.length]; // [1,2,6,24]
        int[] rightValue = new int[nums.length]; // [24,24,12,4]

        int[] result = new int[nums.length]; // [24,12,8,6]

        
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
     */
}