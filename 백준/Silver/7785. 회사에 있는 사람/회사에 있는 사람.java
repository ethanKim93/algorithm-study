
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore.Entry;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		Map<String,Boolean> officeMap = new HashMap<>();
		
		for(int i = 0 ; i < N ; i++) {
			String[] enterLog = br.readLine().split(" ");
			
			String person = enterLog[0];
			String command = enterLog[1];
			
			boolean isEnter = false;
			if("enter".equals(command)) {
				isEnter = true;
			}
			officeMap.put(person, isEnter);
		}
		
		List<String> enterPeaple = new ArrayList<>();
		
		for(Map.Entry<String, Boolean> entry : officeMap.entrySet()) {
			boolean value = entry.getValue();
			if(value) {
				enterPeaple.add(entry.getKey());
			}
		}
		
		Collections.sort(enterPeaple, Collections.reverseOrder());

		for( String person : enterPeaple) {
			System.out.println(person);
		}
	}

}
