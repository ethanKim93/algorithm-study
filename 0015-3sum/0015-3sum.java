class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int left , right , sum;

        Arrays.sort(nums);
        List<List<Integer>>  result = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length - 2; i ++){

            if( i > 0 && nums[i] == nums[i-1] ){
                continue;
            }

            left = i + 1;
            right = nums.length - 1;
            while(left < right){

                sum = nums[i] + nums[left] + nums[right];
                if(sum < 0 ){
                    left ++;
                }
                else if(sum > 0){
                    right --;
                }
                else {
                    List<Integer> triple = new ArrayList<>(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    result.add(triple);

                    while(left < right && nums[left] == nums[left + 1]){
                        left += 1;
                    }

                     while(left < right && nums[right] == nums[right - 1]){
                        right -= 1;
                    }

                    left += 1; 
                    right -= 1;

                }
            }
            
        }
        return result;
    }
}

// for(int j = i+1 ; j < nums.length ; j ++){
//                 int preNum = nums[i] + nums[j];

//                 for(int k = j+1 ; k < nums.length ; k ++){
//                     if(preNum +  nums[k] > 0 ){
//                         break;
//                     }
//                     if( preNum + nums[k] == 0){
//                         List<Integer> triple = new ArrayList<>(Arrays.asList(nums[i] , nums[j] , nums[k]));
//                         result.add(triple);
//                         break;
//                     }
//                 }
//             }