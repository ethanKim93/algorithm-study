import java.util.*;

class Solution {
    static boolean[] visit ; 
    static int[][] coms ;
    static int N ;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = n;
        visit = new boolean[n];
        coms = computers;
        for(int i = 0 ; i < n ; i++){

            if(visit[i] != true){
                dfs(i);
                answer += 1;
            }
            
        }
        return answer;
    }
    
    void dfs(int i){
        visit[i] = true;

        for(int j = 0 ; j < N ; j ++){
            if(visit[j] == false && coms[i][j] == 1){
                dfs(j);
            }
        }
    }
}