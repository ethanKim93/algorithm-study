import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<Integer> col = new ArrayList<Integer>();
        
        for(int[] size : sizes){
            if (size[0]<size[1]){
                row.add(size[1]);
                col.add(size[0]);
            }
            else{
                row.add(size[0]);
                col.add(size[1]);
            }
        }
        int maxRow = Collections.max(row);
        int maxCol = Collections.max(col);
        
    
        int answer = maxRow*maxCol;
        return answer;
    }
}