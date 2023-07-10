import java.util.*;

class Solution {
    boolean [] check = new boolean[10];
    ArrayList<Integer> arr = new ArrayList<Integer>();
    
    public void dfs(String numbers,String temp,int m){
        if (temp.length() == m){
            int num = Integer.parseInt(temp);
            if(!arr.contains(num))
               arr.add(num);
        }
        
        for(int i=0;i<numbers.length();i++){
            if(!check[i]){
                check[i] = true;
                String temp2 = temp + numbers.charAt(i);
                dfs(numbers,temp2,m);
                check[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if( n <2 ){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i == 0 ) return false;
        }
        return true;
    }
        
    
    public int solution(String numbers) {
        int answer = 0;
        
        String temp = "";
        for(int i = 0 ; i <numbers.length();i++){
            dfs(numbers,temp,i+1);     
        }
        for(int i=0; i<arr.size(); i++){
            if(isPrime(arr.get(i))) answer++;              
        }
        return answer;
    }
}