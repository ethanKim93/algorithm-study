import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        int days = 0; 
        int cnt = 1;
        for(int i = 0; i < progresses.length ; i ++){
            // double을 써주지 않으면 올림이 제대로 되지 않음
           int expire = (int) Math.ceil((double)(100 - progresses[i])/speeds[i]); 
           if(days < expire){
               if(days != 0){
                    answerList.add(cnt);
                    cnt = 1 ;
               }
               days = expire;
               continue;
           }
           cnt += 1;
        }
        answerList.add(cnt);
     
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}