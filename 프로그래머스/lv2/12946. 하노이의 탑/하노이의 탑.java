import java.util.ArrayList;
import java.util.List;

class Solution {
    private void hanoi(int n,int from,int to,List<int[]> process){
        if(n == 1){
            process.add(new int[]{from,to});
            return;
        }
        
        int empty = 6 - from - to;
        
        //빈칸으로 보냄
        hanoi(n-1,from,empty,process);
        //마지막 하나는 바로 to 로보냄
        hanoi(1,from,to,process);
        //빈칸에서 to로 보냄 
        hanoi(n-1,empty,to,process);
        
    }
    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n,1,3,process);
        return process.toArray(new int[0][]);
    }
}