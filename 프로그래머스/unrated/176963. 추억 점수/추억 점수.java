import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> names = new HashMap<>();
        for(int i = 0; i < name.length ; i ++){
            names.put(name[i],yearning[i]);
        }
        
        for(int j = 0; j < photo.length ; j ++){
            int total = 0;
            for(int k = 0 ; k < photo[j].length ; k ++){
                String n = photo[j][k];
                total += names.getOrDefault(n,0);
            }
            answer[j] = total;
        }
        
        System.out.println(names);
        return answer;
    }
}