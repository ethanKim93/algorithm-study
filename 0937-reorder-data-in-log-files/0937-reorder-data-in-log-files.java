class Solution {
    public String[] reorderLogFiles(String[] logs) {

        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for(String log : logs){
            String[] logArr = log.split(" ");
            char sample = logArr[1].charAt(0);
            if(Character.isLetter(sample)){
                letters.add(log);
            }else{
             digits.add(log);   
            }
        }

        String[] result = new String[logs.length];


        letters.sort((s1,s2) -> {

            String[] pre = s1.split(" ",2);
            String[] next = s2.split(" ",2);

            int compared = pre[1].compareTo(next[1]);

            if(compared == 0){
                return pre[0].compareTo(next[0]);
            }

            return compared;
        });


        for(int i = 0 ; i <letters.size() ; i++ ){
            String letter = letters.get(i);
            result[i] = letter;
        }

        for(int i = 0 ; i < digits.size() ; i++ ){
            String digit = digits.get(i);
            result[letters.size() + i] = digit;
        }

        return result;
    }

 
}