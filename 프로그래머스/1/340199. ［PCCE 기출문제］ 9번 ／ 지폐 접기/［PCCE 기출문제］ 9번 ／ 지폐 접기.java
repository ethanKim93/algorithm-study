class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMax = Math.max(wallet[0],wallet[1]); 
        int walletMin = Math.min(wallet[0],wallet[1]); 
        
        while(true){
            int billMax = Math.max(bill[0],bill[1]); 
            int billMin = Math.min(bill[0],bill[1]);   
            if(billMin <= walletMin && billMax <= walletMax){
                return answer;
            }
            
            bill[0] = (int) billMax / 2;
            bill[1] = billMin;

            answer ++;
        }
        
    }
}