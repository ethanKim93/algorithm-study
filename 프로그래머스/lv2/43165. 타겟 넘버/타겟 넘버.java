class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        cal(0,0,numbers,target);
        return answer;
    }
    
    static void cal(int index , int value , int[] numbers ,int target ){
        
        int size = numbers.length;
        
        // 종료 조건
        if(index == size){
            // System.out.println(value);
            if(value == target){
                answer += 1;
            }
            return;
        }
        
        cal(index+1,value+numbers[index],numbers,target);
        cal(index+1,value-numbers[index],numbers,target);
    }
}