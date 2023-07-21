import java.util.*;

class Solution {
    public int solution(int[] citations) {
         Arrays.sort(citations);
        int answer = 0;
        
        for(int i = 0 ; i < citations.length; i++){
//             int h = citations.length - i;   // 논문 개수

//             if(citations[i] >= h){
//                 answer = h;
//                 break;
//             }
            if(citations.length - i <= citations[i] ){
                answer = citations.length - i;
                break;
            
            }
        }
        return answer;
    }
}