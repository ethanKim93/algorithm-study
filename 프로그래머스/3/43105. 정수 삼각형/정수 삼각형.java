import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] repository = new int[triangle.length][triangle.length];
        repository[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++){
          for(int j = 0 ; j < triangle[i].length ; j++){
              int leftValue = repository[i-1][j] +triangle[i][j];
              int rightValue = 0;
              if(j >= 1){
               rightValue = repository[i-1][j-1] +triangle[i][j];
              }
              int maxValue = Math.max(leftValue,rightValue);
              repository[i][j] = maxValue;
              answer = Math.max(maxValue,answer);
          }  
        }
        return answer;
    }
}