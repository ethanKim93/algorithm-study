import java.io.*;
import java.util.*;

public class Main {
	static int N, K, L;
	static int[][] board;
	static Queue<ArrayList<Object>> queue = new LinkedList<>();
	static int X;
	static String C;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int D;
	static int cnt = 0;
	static int r, c = 0;
	static int tailX, tailY = 0;
	static Queue<ArrayList<Integer>> tail = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		board = new int[N][N];

		board[0][0] = 2;
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x - 1][y - 1] = 1;
		}
		L = Integer.parseInt(br.readLine());

		for (int j = 0; j < L; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Object> cmd = new ArrayList<>();

			int t = Integer.parseInt(st.nextToken());
			String d = st.nextToken();

			cmd.add(t);
			cmd.add(d);

			queue.add(cmd);
		}
		D = 0;
		ArrayList<Integer> addtails = new ArrayList<>();
		addtails.add(0);
		addtails.add(0);
		tail.add(addtails);
		game();
		System.out.print(cnt+1);
	}

	static void game() {
		ArrayList<Object> cmd = queue.poll();
		X = (int) cmd.get(0);
		C = (String) cmd.get(1);

		while (true) {
			// cnt가 같다면
			if (cnt == X) {
				// 새로 뽑기
				if (C.equals("D")) {
					D = (D + 1) % 4;
				} else {
					D = (D + 3) % 4;
				}
				cmd = queue.poll();
				if (cmd != null) {
					X = (int) cmd.get(0);
					C = (String) cmd.get(1);

				}
			}
			//
			int dr = r + dx[D];
			int dc = c + dy[D];
			// 벽에 부딫히면 종료
			if (dr < 0 || dr >= N || dc < 0 || dc >= N) {
				break;
			}
			// 자기몸에 부딫히면 종료
			if (board[dr][dc] == 2) {
				break;
			}
			// 사과를 못먹는 다면
			if (board[dr][dc] != 1) {

				ArrayList<Integer> tails = tail.poll();
				tailX = tails.get(0);
				tailY = tails.get(1);
				board[tailX][tailY] = 0;

			}
			// 뱀이 이동
			board[dr][dc] = 2;
			ArrayList<Integer> addtails = new ArrayList<>();
			addtails.add(dr);
			addtails.add(dc);
			tail.add(addtails);

			r = dr;
			c = dc;

			cnt++;
		}
	}
}
