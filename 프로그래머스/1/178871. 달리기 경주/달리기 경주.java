import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String , Integer > playerPositon = new HashMap<>();
        
        for(int i = 0; i < players.length ; i++ ){
            String player = players[i];
            playerPositon.put(player , i);
        }
        
        for(String call : callings){
            
            int nowPosition = playerPositon.get(call);
            
            String fastPlayer = players[nowPosition];
            String slowPlayer = players[nowPosition-1];
            
            players[nowPosition -1] =  fastPlayer;
            players[nowPosition ] = slowPlayer;
            
            playerPositon.put(slowPlayer, nowPosition);
            playerPositon.put(fastPlayer, nowPosition -1);

        }
        
        return players;
    }
}