import java.util.*;

class Solution {
    
    static int[] dr = {0,1,-1,0};
    static int[] dc = {1,0,0,-1};
    
    static public class Pair{
        int x;
        int y;
        
        public Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visit = new boolean[m][n];

        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j ++){
            
                if(picture[i][j] == 0){
                    continue;
                }
                
                if(visit[i][j]){
                    continue;
                }
                
                visit[i][j] = true;
                numberOfArea += 1;
                int areaSize = 1;
                Deque<Pair> stack = new LinkedList<>();
                stack.add(new Pair(i,j));
    
                
                while(!stack.isEmpty()){
                
                    Pair pair = stack.pop();
                    visit[pair.x][pair.y] = true;
                    
                    for(int d = 0; d < 4 ; d++){
                        int dx = dr[d] + pair.x;
                        int dy = dc[d] + pair.y;
                        
                        if(dx < 0 || dx >= m || dy < 0 || dy >= n || visit[dx][dy]){
                            continue;
                        }
                        
                        if(picture[pair.x][pair.y] != picture[dx][dy] ){
                            continue;
                        }
                        visit[dx][dy] = true;
                        areaSize += 1;
                        stack.add(new Pair(dx,dy));

                    }
                }
                
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea,areaSize);
                // System.out.println(areaSize + "#" + picture[i][j]);
                // System.out.println(Arrays.deepToString(visit));
                
            }
        }
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

