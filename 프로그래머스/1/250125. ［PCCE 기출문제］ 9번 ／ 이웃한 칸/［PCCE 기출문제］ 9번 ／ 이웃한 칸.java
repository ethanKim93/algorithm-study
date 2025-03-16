class Solution {
    
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int n = board.length;
        String targetColor = board[h][w];
        
        for(int i = 0 ; i < 4 ; i ++){
                
            int row = h + dx[i];
            int col = w + dy[i];

            if(row >= 0 && row < n && col >= 0 && col < n ){
               if(targetColor.equals(board[row][col])){
                   answer ++;
               }
            }

        }
            
        return answer;
    }
}