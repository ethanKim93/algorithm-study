class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        for(int i = 0 ; i < s.length()  ; i ++){
            for(int j = s.length()  ; j > i  ; j --){
                String subString = s.substring(i,j);
                if(isPalindrom(subString)){
                    if(answer.length() <= subString.length()){
                        answer =  subString;
                    }
                }
            }    
        }
        return answer;
    }

    private boolean isPalindrom(String s ){

        int start = 0;
        int end = s.length() -1 ;

        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
        
    }
}