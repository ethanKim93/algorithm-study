import java.util.*;
import java.awt.*;
class Solution {
    
    int[] dx = {0,1,-1,0};
    int[] dy = {1,0,0,-1};
    
    static class Robot{
        
        int x;
        int y;
        int cnt;
        
        public Robot(int x, int y , int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] maps) {

        int x = 0; 
        int y = 0; 
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        int[][] visit = new int[n][m];
        Queue<Robot> queue = new LinkedList<Robot>();
        
        // 초기화
        visit[0][0] = 1;
        queue.offer(new Robot(0,0,1));
        
        while(!queue.isEmpty()){
            
            Robot p = queue.poll();
            for(int d = 0 ; d < 4 ; d++){

                int cnt = p.cnt;
                
                int dr = p.x + dx[d];
                int dc = p.y + dy[d];
                if(dr < 0 || dc < 0 || dr == n || dc == m || maps[dr][dc] == 0|| visit[dr][dc] == 1){
                    continue;
                }
                if(dr == n-1 && dc == m-1){
                    return cnt+1;
                }
                visit[dr][dc] = 1; 
                queue.add(new Robot(dr,dc,cnt+1));
            }
        }
        
        return -1;
    }
    


}