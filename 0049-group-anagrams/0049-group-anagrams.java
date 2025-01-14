class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = String.valueOf(strArr);
            List<String> values = map.getOrDefault(key,new ArrayList<>());
            values.add(str);
            map.put(key,values);
        }    
        return new ArrayList<>(map.values());
    }
}