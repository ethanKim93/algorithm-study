class Solution {
    public int solution(String name) {
        int answer = 0;
        int moveCount = name.length() - 1;
        
        for(int i = 0 ; i < name.length() ; i ++){
            char c = name.charAt(i);
            answer += Math.min('a' - c  -6, c - 'A');

            if(i < name.length() -1 && name.charAt(i + 1) == 'A'){
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A'){
                    endA ++ ;
                }
                // 오른쪽으로 갔다 왼쪽으로 오는 경우
                moveCount = Math.min(moveCount,i*2 + (name.length() - endA));
                // 왼쪽으로 갔다 오른쪽으로 오는경우
                moveCount = Math.min(moveCount,i + (name.length() - endA) * 2);

            }

        }
        return answer + moveCount;
    }
}