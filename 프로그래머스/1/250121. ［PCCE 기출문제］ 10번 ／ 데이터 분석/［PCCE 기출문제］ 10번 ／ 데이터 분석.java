import java.util.*;

class Solution {
    
    private static final List<String> DATA_HEAD_LIST = 
        Arrays.asList("code","date","maximum","remain");
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int extIndex = DATA_HEAD_LIST.indexOf(ext);
        int sortIndex = DATA_HEAD_LIST.indexOf(sort_by);
        
        List<int[]> aiDatas = new ArrayList<>();
        for(int[] aiData : data){
           if(aiData[extIndex] > val_ext){
               continue;
           }
           aiDatas.add(aiData);
        }
        
        aiDatas.sort((o1, o2) -> o1[sortIndex] - o2[sortIndex] );
        
        return aiDatas.toArray(new int[aiDatas.size()][4]);
    }
}
