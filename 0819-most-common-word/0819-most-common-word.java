class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        Map<String, Integer> map = new HashMap<>();
        Set<String> banSet = new HashSet<>();
        for(String ban : banned ){
            banSet.add(ban.toLowerCase());
        }

        for(String word : paragraph.replaceAll("\\W+"," ").toLowerCase().split(" ")){
            // if(word.equals("")){
            //     continue;
            // }
            
            if(banSet.contains(word) ){
                continue;
            }
            int count =  map.getOrDefault(word,0);
            map.put(word,count+1);
        }

        // String result = "";
        // int max = 0;
        // for(Map.Entry<String,Integer> entry : map.entrySet()){
        //     String key = entry.getKey();
        //     int value = entry.getValue();
        //     if(max < value){
        //         result = key;
        //         max = value;
        //     }
            
        // }

        // return result;

        return Collections.max(map.entrySet(),Map.Entry.comparingByValue()).getKey();
    }
}