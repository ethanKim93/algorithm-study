class Solution {
    public int solution(String[] babbling) {
        
        String[] announces = { "aya", "ye", "woo", "ma"};
        
        
        int answer = 0;
        for(String bab : babbling){
            for(String announce : announces){
                bab = bab.replace(announce," ");
            }
            
            if(bab.isBlank()){
                answer++;
            }
            
        }
        return answer;
    }
}