
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());


		
		Set<String> result = new HashSet<>() ;
		

		st = new StringTokenizer(br.readLine());
		for(long i = 0 ; i < n1 ; i++) {
			String value = st.nextToken();
				result.add(value);
		
		}
		

		st = new StringTokenizer(br.readLine());
		for(long i = 0 ; i < n2 ; i++) {
			String value = st.nextToken();
			if(result.contains(value)) {
				result.remove(value);
			}else {
				result.add(value);
			}
		}
		
	
		
		System.out.println(result.size());

	}

}
