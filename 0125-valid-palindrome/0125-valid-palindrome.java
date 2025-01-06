class Solution {
    public boolean isPalindrome(String s) {
        
        char[] splitChar = s.toCharArray();
        
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();  

        for(int i = 0 ; i < splitChar.length ; i ++){
            if(!Character.isLetterOrDigit(splitChar[i])){
                continue;
            }
            a.append(Character.toUpperCase(splitChar[i]));
        }             

        for(int i = splitChar.length -1 ; i >= 0 ; i --){
            if(!Character.isLetterOrDigit(splitChar[i])){
                continue;
            }
        
            b.append(Character.toUpperCase(splitChar[i]));
        }

        return a.toString().equals(b.toString());
    }
}