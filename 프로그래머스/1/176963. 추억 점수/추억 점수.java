import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String , Integer> score = new HashMap<>();
       
        for(int i = 0 ; i < name.length ; i++){
            score.put(name[i],yearning[i]);
        }
        
        for(int i = 0 ; i < photo.length ; i++){
            int yearTotal = 0;        
            for(int j = 0 ; j < photo[i].length ; j++){
                yearTotal += score.getOrDefault(photo[i][j],0);
            }
            answer[i] = yearTotal;
        }
        return answer;
    }
}