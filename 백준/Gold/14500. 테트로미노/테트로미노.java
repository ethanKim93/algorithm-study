import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans = 0;
	static int N, M;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i, j, 1, board[i][j], visit);
				visit[i][j] = false;
				check(i, j);
			}
		}
		System.out.println(ans);
	}

	static void dfs(int y, int x, int cnt, int sum, boolean[][] visit) {

		if (cnt >= 4) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int ny = y + +dy[d];
			int nx = x + +dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
				continue;
			}
			visit[ny][nx] = true;
			dfs(ny, nx, cnt + 1, sum + board[ny][nx], visit);
			visit[ny][nx] = false;
		}
	}

	static void check(int y, int x) {
		if (y < N - 2 && x < M - 1)
			ans = Math.max(ans, board[y][x] + board[y + 1][x] + board[y + 2][x] + board[y + 1][x + 1]);

		if (y < N - 2 && x > 0)
			ans = Math.max(ans, board[y][x] + board[y + 1][x] + board[y + 2][x] + board[y + 1][x - 1]);

		if (y < N - 1 && x < M - 2)
			ans = Math.max(ans, board[y][x] + board[y][x + 1] + board[y][x + 2] + board[y + 1][x + 1]);

		if (y > 0 && x < M - 2)
			ans = Math.max(ans, board[y][x] + board[y][x + 1] + board[y][x + 2] + board[y - 1][x + 1]);
	}
}
