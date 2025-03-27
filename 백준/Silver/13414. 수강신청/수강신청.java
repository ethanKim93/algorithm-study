
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		String[] userArr = new String[L]; 
		Map<String,Integer> lastIndexMap = new HashMap<>();
		for(int i  = 0 ; i < L ; i ++) {
			
			String userId = br.readLine();
			userArr[i] = userId;
			if(lastIndexMap.containsKey(userId)) {
				userArr[lastIndexMap.get(userId)] = null;
				lastIndexMap.put(userId, i);
			}else {
				lastIndexMap.put(userId, i);
			}
			
		}
		
		int index = 0;
		while(K > 0 && index < L) {
			if(userArr[index] != null) {
				System.out.println(userArr[index]);
				K --;
			}

			index ++;
		}
		
	}

}
