import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> idList = Arrays.asList(id_list);
        int[] answer = new int[id_list.length];

        int [][] reportMap = new int[id_list.length][id_list.length];
        
        // user1 신고 한 사람 . user2 신고 당한 사람
        for(String re : report){
            String[] people = re.split(" ");
            String user1 =  people[0];
            String user2 =  people[1];
            
            int user1index = idList.indexOf(user1);
            int user2index = idList.indexOf(user2);
            reportMap[user2index][user1index] = 1;
        }
        for(int i = 0; i < id_list.length ; i++){
            if(Arrays.stream(reportMap[i]).sum() < k){
                continue;
            }
            for(int j = 0; j < id_list.length ; j++){
                if(reportMap[i][j] == 1){
                    answer[j] += 1;
                } 
            }
        }
        return answer;
    }
}