class Solution {
    public int solution(int n) {
        int m = 1234567;
        int[] fibo = new int[n];
        
        fibo[1] = 1;
        
        for(int i = 2; i < n ; i++){
            fibo[i] = fibo[i-2]  % m + fibo[i-1]  % m ;
        }
        
        int answer = (int)(fibo[n-2]  % m+ fibo[n-1]  % m) % m;
        return answer;
    }
}