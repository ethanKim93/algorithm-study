import java.util.*;

class Solution {
    static boolean[] visit;
    static Set<Set<String>> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        
        visit = new boolean[user_id.length];
        
        dfs(new HashSet<String>(),user_id,banned_id,0);     
        System.out.println(set);
        return set.size();
    }
    
    void dfs(Set<String> banned, String[] user_id, String[] banned_id , int index){
        // 종료 조건 
        if(index == banned_id.length){
            System.out.println(set);
            set.add(banned);
            return;
        }
        
        String ban = banned_id[index];
        for(int i = index+1 ; i < user_id.length ; i++){
            if(!visit[i] && isBan(user_id[i],ban)){
                visit[i] = true;
                banned.add(user_id[i]);
                System.out.println(user_id[i]);
                dfs(banned,user_id,banned_id,index+1);
                banned.remove(user_id[i]);
                visit[i] = false;
            }
        }
    }
    
    static boolean isBan(String userId, String banId){
        
        if(userId.length() != banId.length()){
            return false;
        }
        
        for(int i = 0 ; i < userId.length() ; i ++){
            if(banId.charAt(i) != '*' && banId.charAt(i) != userId.charAt(i)){
               return  false;
            }
        }
        return true;
    }
}