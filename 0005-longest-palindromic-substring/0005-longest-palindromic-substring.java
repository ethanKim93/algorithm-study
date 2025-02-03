class Solution {

    int left, maxLen;

    public String longestPalindrome(String s) {

        int length = s.length();

        if(length < 2) return s;
        
        for(int i = 0; i < length -1 ;i ++){
            extendPalindrom(s,i,i+1);
            extendPalindrom(s,i,i+2);
        }

        return s.substring(left,left + maxLen);

    }

    private void extendPalindrom(String s,int i , int j){

        while(i >= 0 && s.length()> j && s.charAt(i) == s.charAt(j)){
            i --;
            j ++;
        }

        if(maxLen < j - i -1){
            left = i + 1;
            maxLen = j - i -1;
        }
    }
}