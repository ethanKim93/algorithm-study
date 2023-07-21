class Solution {
    public String solution(String s) {
        String answer = s.chars().boxed().sorted((s1,s2)-> s2 - s1)
            .collect(StringBuilder :: new,
                    StringBuilder :: appendCodePoint,
                    StringBuilder :: append)
            .toString();
        return answer;
    }
}