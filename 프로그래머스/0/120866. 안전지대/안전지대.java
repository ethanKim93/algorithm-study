class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        for (int i = 0 ; i < board.length ; i ++){
            for (int j = 0 ; j < board[i].length ; j ++){
                if(board[i][j] == 1){
                    for(int r = -1 ; r <= 1 ; r++){
                        for(int c = -1 ; c <= 1 ; c++){
                            if(i+r < 0 || i+r >= board.length || j+c < 0 || 
                               j+c >= board[i+r].length ){
                                continue;
                            }
                            if(board[i+r][j+c] == 0){
                                board[i+r][j+c] = 2;
                            }
                        }   
                    }
                }
            }   
        }
        
         for (int i = 0 ; i < board.length ; i ++){
            for (int j = 0 ; j < board[i].length ; j ++){
                if(board[i][j] == 0){
                    answer += 1; 
                }
            }   
        }
        return answer;
    }
}