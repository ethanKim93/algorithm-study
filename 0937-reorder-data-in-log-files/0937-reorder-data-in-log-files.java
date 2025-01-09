class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String[]> letters = new ArrayList<>();
        List<String[]> digits = new ArrayList<>();

        // 문자 타입, 숫자 타입 구분
        for(String log : logs){
            String[] logArr = log.split(" ");
            char sample = logArr[1].charAt(0);
            if(Character.isLetter(sample)){
                letters.add(logArr);
            }else{
             digits.add(logArr);   
            }
        }

        String[] result = new String[logs.length];

        //문자열 정렬
        for(int i = 0 ; i <letters.size() - 1; i++ ){
            for(int j = 0; j < letters.size() - i - 1 ; j++){
                String[] preLogs = letters.get(j);
                String[] nextLogs = letters.get(j + 1);


                StringBuilder preLogTail = new StringBuilder();
                for(int k = 1 ; k < preLogs.length; k++){
                    preLogTail.append(" ");
                    preLogTail.append(preLogs[k]);
                }
                 
                StringBuilder nextLogTail = new StringBuilder();
                for(int k = 1 ; k < nextLogs.length; k++){
                    nextLogTail.append(" ");
                    nextLogTail.append(nextLogs[k]);
                }
                
                if(preLogTail.toString().equals(nextLogTail.toString())){
                    if(preLogs[0].compareTo(nextLogs[0]) > 0){
                        String[] temp = letters.get(j);
                        letters.set(j,letters.get(j+1)); 
                        letters.set(j+1,temp); 
                    }
                }else if(preLogTail.toString().compareTo(nextLogTail.toString()) > 0){
                    String[] temp = letters.get(j);
                    letters.set(j,letters.get(j+1)); 
                    letters.set(j+1,temp); 
                }

            }
        }

        // 숫자 정렬 
        // for(int i = 0 ; i <digits.size() - 1; i++ ){
        //     for(int j = 0; j < digits.size() - i - 1 ; j++){
        //         String[] preLogs = digits.get(j);
        //         String[] nextLogs = digits.get(j + 1);

        //         int minSize = Math.min(preLogs.length,nextLogs.length);

        //         for(int k = 1 ; k < minSize; k++){
        //             int pL = Integer.parseInt(preLogs[k]);
        //             int nL = Integer.parseInt(nextLogs[k]);
        //             System.out.println(pL +" " + nL);
        //             if(pL > nL){
        //                 String[] temp = digits.get(j);
        //                 digits.set(j,digits.get(j+1)); 
        //                 digits.set(j+1,temp); 
        //                 break;
        //             }   
        //         }
                 
        //     }
        // }



        for(int i = 0 ; i <letters.size() ; i++ ){
            String[] letter = letters.get(i);
            StringBuilder letterLog = new StringBuilder();
            letterLog.append(letter[0]);
            for(int k = 1 ; k < letter.length; k++){
                letterLog.append(" ");
                letterLog.append(letter[k]);
            } 
            result[i] = letterLog.toString();
        }

        for(int i = 0 ; i < digits.size() ; i++ ){
            String[] digit = digits.get(i);
            StringBuilder digitLog = new StringBuilder();
            digitLog.append(digit[0]);
            for(int k = 1 ; k < digit.length; k++){
                digitLog.append(" ");
                digitLog.append(digit[k]);
            } 
            result[letters.size() + i] = digitLog.toString();
        }

        return result;
    }

 
}