import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {

		int[] dice = new int[6];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int move = Integer.parseInt(st.nextToken()) - 1;
			X += dx[move];
			Y += dy[move];
			if (X < 0 || X >= N || Y < 0 || Y >= M) {
				X -= dx[move];
				Y -= dy[move];
				continue;
			}

			switch (move) {
			case 0:
				move_right(dice);
				break;
			case 1:
				move_left(dice);
				break;
			case 2:
				move_up(dice);
				break;
			case 3:
				move_down(dice);
				break;
			}

			// 바닥면 복사
			if (board[X][Y] == 0) {
				board[X][Y] = dice[1];
			} else {
				dice[1] = board[X][Y];
				board[X][Y] = 0;
			}

			System.out.println(dice[0]);
		}
	}

	public static void move_right(int[] dice) {
		// 윗 -> 오 -> 바닥 -> 왼 -> 윗
		int temp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = temp;

	}

	public static void move_left(int[] dice) {
		// 윗 -> 왼 -> 바 -> 오 -> 윗
		int temp = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = temp;

	}

	public static void move_up(int[] dice) {
		// 윗 -> 뒷 -> 바 -> 앞 -> 윗
		int temp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = temp;

	}

	public static void move_down(int[] dice) {
		// 윗 -> 앞 -> 바 -> 뒷 -> 윗
		int temp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = temp;

	}

}
