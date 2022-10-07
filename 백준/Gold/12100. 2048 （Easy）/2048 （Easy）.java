import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] boards;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static Stack st;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		boards = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				boards[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		game(0);
		System.out.println(answer);
	}

	public static void game(int count) {
		if (count == 5) {
			findMax();
			return;
		}

		int copy[][] = new int[N][N];
		for (int i = 0; i < N; i++)
			copy[i] = boards[i].clone();

		for (int i = 0; i < 4; i++) {
			move(i);
			game(count + 1);
			for (int a = 0; a < N; a++)
				boards[a] = copy[a].clone();
		}

	}

	public static void move(int dir) {
		switch (dir) {
		case 0:
			for (int i = 0; i < N; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < N; j++) {
					if (boards[j][i] != 0) {
						if (block == boards[j][i]) {
							boards[index - 1][i] = block * 2;
							block = 0;
							boards[j][i] = 0;
						} else {
							block = boards[j][i];
							boards[j][i] = 0;
							boards[index][i] = block;
							index++;
						}
					}
				}
			}
			break;
		case 1:
			for (int i = 0; i < N; i++) {
				int index = N-1;
				int block = 0;
				for (int j = N-1; j >=0 ; j--) {
					if (boards[j][i] != 0) {
						if (block == boards[j][i]) {
							boards[index + 1][i] = block * 2;
							block = 0;
							boards[j][i] = 0;
						} else {
							block = boards[j][i];
							boards[j][i] = 0;
							boards[index][i] = block;
							index--;
						}
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				int index = 0;
				int block = 0;
				for (int j = 0; j < N; j++) {
					if (boards[i][j] != 0) {
						if (block ==boards[i][j]) {
							boards[i][index - 1] = block * 2;
							block = 0;
							boards[i][j] = 0;
						} else {
							block = boards[i][j];
							boards[i][j] = 0;
							boards[i][index] = block;
							index++;
						}
					}
				}
			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				int index = N-1;
				int block = 0;
				for (int j = N-1; j >=0 ; j--) {
					if (boards[i][j] != 0) {
						if (block ==boards[i][j]) {
							boards[i][index + 1] = block * 2;
							block = 0;
							boards[i][j] = 0;
						} else {
							block = boards[i][j];
							boards[i][j] = 0;
							boards[i][index] = block;
							index--;
						}
					}
				}
			}
			break;
		}
	}

	public static void findMax() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				answer = Math.max(answer, boards[i][j]);
	}

}

class Board {
	int cnt;
	String[][] map;

	public Board(int cnt, String[][] map) {
		this.cnt = cnt;
		this.map = map;
	}
}