
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// test case만큼 실행
		for (int tc = 0; tc < T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			boolean[][] board = new boolean[M][N];
			boolean[][] visit = new boolean[M][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[x][y] = true;

			}

			int result = 0;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {

					if (!board[i][j] || visit[i][j]) {
						continue;
					}
					Deque<Node> stack = new LinkedList<>();
					stack.push(new Node(i, j));
					visit[i][j] = true;
					result++;
					while (!stack.isEmpty()) {

						Node node = stack.peek();

						boolean flag = false;
						for (int d = 0; d < 4; d++) {

							int dr = node.x + dx[d];
							int dc = node.y + dy[d];

							if (dr < 0 || dr >= M || dc < 0 || dc >= N) {
								continue;
							}
							if (!visit[dr][dc] && board[dr][dc]) {
								stack.push(new Node(dr, dc));
								visit[dr][dc] = true;
								flag = true;
								break;
							}

						}

						if (!flag) {
							stack.pop();
						}

					}

				}
			}

			System.out.println(result);

		}
	}

}