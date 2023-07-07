import java.util.*; 



class Solution {
    static boolean[] visit;
    static List<String> allRoute;
    
    public String[] solution(String[][] tickets) {
        
        
        visit = new boolean[tickets.length];
        allRoute = new ArrayList<>();
        List<String> route = new ArrayList<>();
        dfs(route,"ICN",tickets);
        Collections.sort(allRoute);
        
        String answerList = allRoute.get(0);
        String[] answer = answerList.split(",");
        return answer;
    }
    
    void dfs(List<String> route, String start ,String[][] tickets) {
        route.add(start);
        if(route.size()-1 == tickets.length)  {
            allRoute.add(String.join(",",route));
        }      
        
        for(int i = 0; i < visit.length ; i++){
            String[] ticket = tickets[i]; 
            String ts =  ticket[0];
            String te =  ticket[1];
            
            if(visit[i] != true && ts.equals(start)){
                visit[i] = true;
                // route.add(start);
                dfs(new ArrayList<>(route),te,tickets);
                visit[i] = false;
            }
        }
    }
}