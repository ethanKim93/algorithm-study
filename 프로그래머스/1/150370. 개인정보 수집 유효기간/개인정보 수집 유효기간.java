import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String,Integer> termMap = new HashMap<>();
        
        String[] todayArr = today.split("\\.");
        
//         System.out.println(today);

//         System.out.println(Arrays.deepToString(todayArr));

        
        int todayYear = Integer.parseInt(todayArr[0]);
        int todayMonth = Integer.parseInt(todayArr[1]);
        int todayDay = Integer.parseInt(todayArr[2]);

        
        for(String term : terms){
            String[] termArr = term.split(" ");
            termMap.put(termArr[0],Integer.parseInt(termArr[1]));
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        for(int i = 0 ; i <privacies.length ; i++ ){
            String privace = privacies[i];
            String[] privaceArr = privace.split(" ");
            
            String[] privaceDay =  privaceArr[0].split("\\.");
            
            int priTerm = termMap.get(privaceArr[1]);
            
            int priYear = Integer.parseInt(privaceDay[0]);
            int priMonth = Integer.parseInt(privaceDay[1]);
            int priDay = Integer.parseInt(privaceDay[2]);
     
            priDay = (priDay -1);
            if(priDay == 0){
                priMonth -=1;
                priDay = 28;
            }
            priMonth += priTerm ;
            priYear += priMonth / 12;
            priMonth =  priMonth % 12;
            if(priMonth == 0){
                priYear -= 1;
                priMonth = 12;
            }
        
            if(priYear - todayYear < 0){
                answerList.add(i+1);
                continue;
            }else if(priYear - todayYear > 0){
                continue;
            }
            
            if(priMonth - todayMonth < 0){
                answerList.add(i+1);
                continue;
            }else if(priMonth - todayMonth > 0){
                continue;
            }
            
            if(priDay - todayDay < 0 ){
                answerList.add(i+1);
                continue;
            }
            
            
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i = 0 ; i <answerList.size() ; i++ ){
            answer[i] = answerList.get(i);
        } 
        
        return answer;
    }
}