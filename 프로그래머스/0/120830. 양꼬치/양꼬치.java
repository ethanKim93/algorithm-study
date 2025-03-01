class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        answer += n * 12000;
        
        k -= n/10;
        if(k > 0){
            answer += k * 2000;
        }
        
        return answer;
    }
}