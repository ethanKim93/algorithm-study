import java.util.*;

class Solution {
    
    public static int compress(String s , int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <s.length();i+=n){
            if(i+n >= s.length()){
                sb.append(s.substring(i));
                break;
            }
            String sub1 = s.substring(i,i+n);
            int nextIndex = i + n;
            String sub2 = s.substring(nextIndex);
            int cnt = 1;
            while(sub2.startsWith(sub1)){
                cnt ++;
                nextIndex += n;
                sub2 = s.substring(nextIndex);
                // System.out.println(nextIndex);
                // System.out.println(sb.toString());
                // System.out.println(sub2);
            }
            if(cnt > 1){
                sb.append(cnt + sub1);
                i = nextIndex - n ;
                // System.out.println(sb.toString());
                if( i >= s.length()){
                    break;
                }
                continue;
            }
            sb.append(sub1);
            // System.out.println(sb.toString());
        }
        // System.out.println(n);
        // System.out.println(sb.toString());
        return sb.length();
    }
    
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0 ; i < s.length()/2 +1; i++){
            answer = Math.min(answer,compress(s,i+1));
        }
        return answer;
    }
}