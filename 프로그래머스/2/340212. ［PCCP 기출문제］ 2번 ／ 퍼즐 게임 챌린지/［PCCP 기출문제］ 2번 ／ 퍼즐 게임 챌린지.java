class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int leftLevel = 1;
        
        int rightLevel = -1;
        for(int i = 0 ; i < diffs.length ; i++){
           rightLevel = Math.max(rightLevel, diffs[i]);
        }

        int level = rightLevel / 2;
        while(rightLevel > leftLevel ){
            boolean isComplete = true;
            long time = 0;
            for(int i = 0 ; i < diffs.length ; i ++){
                int diff = diffs[i];
                int preIndex = Math.max(i-1,0);
                int preTime = times[preIndex];
                int currentTime = times[i];
                

                if(diff > level){
                    time += ((diff-level) * (preTime + currentTime));
                }
                time += currentTime;
                

                if(time > limit){
                    leftLevel = level + 1;
                    isComplete = false;
                    break;
                } 
            } 
            if(isComplete){
                rightLevel = level ;
            }
            level = ((rightLevel + leftLevel) / 2)  ;
           
        }
        return level;
    }
}