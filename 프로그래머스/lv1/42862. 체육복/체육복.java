import java.util.*;

class Solution {
    public int solution(int num, int[] lost, int[] reserve) {
        int[] clothes = new int[num+1];
        Arrays.fill(clothes,1);
        clothes[0] = 0;
        Arrays.sort(lost);
        
        for(int n : lost){
            clothes[n] -= 1 ;
        }
        
        for(int n : reserve){
            clothes[n] += 1 ;
        }
        // System.out.println(Arrays.toString(clothes));

        for(int n : lost){
            if(clothes[n] == 0){
              if(n-1 >= 0 && clothes[n-1] > 1){
                  clothes[n] += 1;
                  clothes[n-1] -= 1;
                  continue;
              }
             if(n+1 <= num && clothes[n+1] > 1){
                   clothes[n] += 1;
                   clothes[n+1] -= 1;
              }
                
            } 
        }
        
        // System.out.println(Arrays.toString(clothes));
        return (int)Arrays.stream(clothes).filter(s -> s > 0).count();
    }
}