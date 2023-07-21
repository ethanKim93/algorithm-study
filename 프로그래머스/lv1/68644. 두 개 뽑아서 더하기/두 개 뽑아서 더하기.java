import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < numbers.length-1 ; i ++){
            for(int j = i+1 ; j < numbers.length ; j ++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        // Set은 Integer Type임으로 mapToInt를 통해 변환을 해주어야함
        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}