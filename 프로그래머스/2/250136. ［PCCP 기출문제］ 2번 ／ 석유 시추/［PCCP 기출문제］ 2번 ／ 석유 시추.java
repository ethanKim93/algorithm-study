import java.util.*;

class Solution {
    
    public class Pair{
        int x;
        int y;
        
        public Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        
        int n = land.length;
        int m = land[0].length;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        int[][] visit = new int[n][m];
        int keyValue = 0;
        Map<Integer,Integer> sizeMap = new HashMap<>();
        int maxValue = -1;

        for(int j = 0; j < m ; j++){
            int rowValue = 0;
            Set<Integer> keySet = new HashSet();
            
            for(int i = 0; i < n ; i ++){

                if(land[i][j] == 0){
                    continue;
                }
                
                if(visit[i][j] != 0){
                    Integer key = visit[i][j];
                    if(!keySet.contains(key)){
                        keySet.add(key);
                        rowValue += sizeMap.get(key);
                    }
                    
                    continue;
                }
             
                
                keyValue ++ ; 
                
                Deque<Pair> stack = new LinkedList<>();
                stack.add(new Pair(i,j));
                visit[i][j] = keyValue;
                int size = 0;
                while(!stack.isEmpty()){
        
                    Pair p = stack.poll();
                    size ++;
                    
                    for(int d = 0 ; d < 4 ; d++){
                        int dr = dx[d] + p.x;
                        int dc = dy[d] + p.y;
                        if(dr < 0 || dc < 0 || dr >= n || dc >= m || 
                           visit[dr][dc] != 0 || land[dr][dc] == 0){
                           continue; 
                        }
                        stack.add(new Pair(dr,dc));
                        visit[dr][dc] = keyValue;
                    }
                    
                }
                rowValue += size;
                sizeMap.put(keyValue,size);
                keySet.add(keyValue);
            }
            maxValue = Math.max(maxValue,rowValue);
        }
        

   
        return maxValue;
    }
}