import java.util.*;

class Solution {
    static int[] first = {1,2,3,4,5};
    static int[] second = {2,1,2,3,2,4,2,5};
    static int[] third = {3,3,1,1,2,2,4,4,5,5};
    
    public int[] solution(int[] answers) {
        int a= 0; 
        int b= 0; 
        int c = 0; 
        
        for(int i = 0 ; i < answers.length ; i ++){
            int n = answers[i];
            if(first[i % first.length] == n){
                a ++;
            }
            
            if(second[i % second.length] == n){
               b++; 
            }
            
            if(third[i % third.length] == n){
                c++;
            }
        }
        int maxValue = Math.max(Math.max(a,b),c);
        
        List<Integer> answerList = new ArrayList<>();
        if(maxValue == a){
            answerList.add(1);
        }
        if(maxValue == b){
            answerList.add(2);
        }
        if(maxValue == c){
            answerList.add(3);
        }
        int[] answer =answerList.stream()
                .mapToInt(i -> i)
                .toArray();
            // answerList.toArray(new int[answerList.size()]);

        return answer;
    }
}