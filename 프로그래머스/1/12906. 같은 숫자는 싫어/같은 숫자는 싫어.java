import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> tempList = new ArrayList<>();
        
        tempList.add(arr[0]);
        
        for(int i = 1 ; i < arr.length; i ++){
            if(arr[i-1] != arr[i]){
                tempList.add(arr[i]);
            }
        }
    
        int[] answer = new int[tempList.size()];
        for(int i = 0 ; i < tempList.size(); i ++){
            answer[i] = tempList.get(i);
        }

        return answer;
    }
}