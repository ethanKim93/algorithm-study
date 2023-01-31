import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] homeList = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			homeList[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(homeList);

		int left = 1;
		int right = homeList[N] - homeList[1];
		int d = 0;
		int ans = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int start = homeList[1];
			int count = 1;
			for (int i = 1; i <= N; ++i) {
				d = homeList[i] - start;
				if (d >= mid) {
					count++;
					start = homeList[i];
				}
			}

			if (count >= C) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);

	}

}