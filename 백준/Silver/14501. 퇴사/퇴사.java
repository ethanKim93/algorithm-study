import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<HashMap<String, Integer>> days = new ArrayList<HashMap<String, Integer>>();
	static int maxValue = 0;
	static int[] sums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sums = new int[N+1];
		for (int i = 0; i < N; i++) {
			HashMap<String, Integer> cons = new HashMap<String, Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			cons.put("T", t);
			cons.put("P", p);
			days.add(cons);
		}
		dfs(0, 0);
//		System.out.println(Arrays.toString(sums));
		System.out.println(sums[N]);
	}

	static void dfs(int start, int sum) {	
		for (int i = 0; i < N; i++) {
			HashMap<String, Integer> cons = days.get(i);
			if (i + cons.get("T") > N) {
				sums[i+1] = Math.max(sums[i], sums[i+1]);
				continue;
			}
			if(sums[i + cons.get("T")] < sums[i] + cons.get("P")) {
				sums[i + cons.get("T")] = sums[i] + cons.get("P");
			}
			sums[i+1] = Math.max(sums[i], sums[i+1]);
		}
	}
	

	static void maxFind(int sum) {
		if (maxValue < sum)
			maxValue = sum;
		return;

	}

}
