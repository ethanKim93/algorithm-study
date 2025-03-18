import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        List<Integer> matList =  new ArrayList<>();
        for(int i = 0 ; i < mats.length ; i++){
            matList.add(mats[i]);
        }
        
        for(int i = 0 ; i < park.length ; i++){
            for(int j = 0 ; j < park[i].length ; j++){   
                List<Integer> removeMat = new ArrayList<>(); 
                for(int k = 0 ; k < matList.size() ; k ++){
                    int n = matList.get(k);
                    boolean isCheck = true;
                    for(int r = i ; r < i + n  ; r++){
                        for(int c = j ; c < j + n  ; c++){
                        
                            if(r < 0 || r >= park.length || c < 0 || c >= park[r].length ){
                                isCheck =false;
                                break;
                            }
                            if(!"-1".equals(park[r][c])){
                                isCheck =false;
                                break;
                            }
                        }
                        if(!isCheck){
                            break;
                        }
                    }
                    if(isCheck){
                        removeMat.add(n);
                        answer = Math.max(answer,n);
                    }
                }
                matList.removeAll(removeMat);
            }    
        }
        return answer;
    }
}