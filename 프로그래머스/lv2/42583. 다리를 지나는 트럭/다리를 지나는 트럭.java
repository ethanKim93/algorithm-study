import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int bridgeWeight = 0;
        int time = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int  i = 0 ; i < bridge_length ; i++){
            bridge.add(0);
        }
        
        int truckIndex = 0;
        while(truckIndex < truck_weights.length){
             bridgeWeight -= bridge.poll();
             if(bridgeWeight + truck_weights[truckIndex] <= weight){
                 bridgeWeight+=truck_weights[truckIndex];
                 bridge.add(truck_weights[truckIndex]);
                 truckIndex+=1;
             }else{
                 bridge.add(0);
             }
             time ++;
        }
        
        
        return time+bridge_length;
    }
}