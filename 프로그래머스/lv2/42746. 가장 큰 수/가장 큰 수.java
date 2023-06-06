import java.util.*;

class Solution {
    
        public String solution(int[] numbers) {
            String answer = "";
            boolean except = true;

            List<String> sortList = new LinkedList<String>();
            
            for(int number : numbers){
                sortList.add(String.valueOf(number));
                if(number != 0) except = false;
            }
            Collections.sort(sortList, (num1,num2)-> (num2+num1).compareTo(num1+num2) ) ;
            if(except) {
                answer = "0";
            }else{
                answer =  String.join("", sortList);
            }
            return answer;
        }

}