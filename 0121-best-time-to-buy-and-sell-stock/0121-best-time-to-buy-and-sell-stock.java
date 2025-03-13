class Solution {
    public int maxProfit(int[] prices) {

        int answer = 0;

        int maxRightIndex = prices.length - 1;

        for(int i = 0; i < prices.length; i++ ){
            int newPrice =   prices[maxRightIndex] - prices[prices.length - 1 - i] ;
            answer = Math.max(newPrice,answer);
            if(prices[maxRightIndex] < prices[prices.length - 1 - i] ){
               maxRightIndex = prices.length - 1 - i;
            }
        }
        return answer;
    }
}