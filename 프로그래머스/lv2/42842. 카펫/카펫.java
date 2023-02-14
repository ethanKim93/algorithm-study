class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int mid = brown / 2; 
        boolean flag = true;
        
        while(flag){
            mid = mid - 1;
            for(int i = 0; i <= mid ; i++ ){
                
                if(mid*i == brown+yellow && (mid-2)*(i-2) == yellow ) {
                    flag = false;
                    answer[0] = mid;
                    answer[1] = i;
                    break;
                }
                
            }
                

        }
        
        return answer;
    }
}