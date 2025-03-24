import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong( st.nextToken());
		long M =Long.parseLong( st.nextToken());
		
		Map<String,Long> poketMap = new HashMap<>();
		Map<Long,String> indexMap = new HashMap<>();

		for (long i = 0 ; i < N ; i++) {
			String pocketmon = br.readLine();
			poketMap.put(pocketmon,i+1);
			indexMap.put(i+1,pocketmon);
		}
		
		for (long i = 0 ; i < M ; i++) {
			String line =  br.readLine();
			try {
				long index = Long.parseLong(line);
				System.out.println(indexMap.get(index));
				continue;
			} catch (Exception e) {
				System.out.println(poketMap.get(line));
			}
			
			
		}
	}

}
