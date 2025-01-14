class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = Arrays.toString(strArr);
            List<String> values = map.getOrDefault(key,new ArrayList<>());
            values.add(str);
            map.put(key,values);
        }

        List<List<String>> answer = new ArrayList<>();
        for(String key : map.keySet()){
            answer.add(map.get(key));
        }
    
        return answer;
    }
}