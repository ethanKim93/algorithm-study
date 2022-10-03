import java.io.*;
import java.util.*;


public class Main {

	int solution(int N, int[][] matrix) {
		int answer = 0;
		ArrayList<Integer> arrs = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arrs.add(matrix[i][j]);
			}
		}
		Collections.sort(arrs,Collections.reverseOrder());
		answer = arrs.get(N-1);
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Main M = new Main();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		System.out.println(M.solution(N, matrix));
	}

}
