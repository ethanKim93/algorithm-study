
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] board;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] visit;
	static ArrayList<Virus> viruses;
	static int originEmpty = 0;
	static Virus[] active;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 초기 셋팅
		board = new int[N][N];
		visit = new int[N][N];
		active = new Virus[M];
		viruses = new ArrayList<Virus>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					viruses.add(new Virus(i, j, 0));
				}

				if (board[i][j] == 0) {
					originEmpty++;
				}
			}
		}

		if(originEmpty == 0) {
			System.out.println(0);
			return;
		}
		selectVirus(0, 0);

		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			System.out.println(answer+1);
		}
	}

	static void selectVirus(int start, int count) {
		if (count == M) {
			spreadVirus(originEmpty);
			return;
		}

		for (int i = start; i < viruses.size(); i++) {
			active[count] = viruses.get(i);
			selectVirus(i + 1, count + 1);
		}
	}

	static void spreadVirus(int originEmptyCount) {		
		Queue<Virus> queue = new LinkedList<>();
        boolean[][] infected = new boolean[N][N];

		for (Virus vs : active) {
			infected[vs.x][vs.y] = true;
			queue.add(vs);
		}

		while (!queue.isEmpty()) {
			Virus v = queue.poll();

			for (int d = 0; d < 4; d++) {

				int dr = dx[d] + v.x;
				int dc = dy[d] + v.y;

				if (dr < 0 || dc < 0 || dr >= N || dc >= N || board[dr][dc] == 1 || infected[dr][dc]) {
					continue;
				}

				if (board[dr][dc] == 0) {
					originEmptyCount--;
				}
				if (originEmptyCount == 0) {
					if(answer > v.cnt)
						answer = v.cnt;
					return;
				}
				infected[dr][dc] = true;
				queue.add( new Virus(dr, dc, v.cnt + 1));
			}

		}

		return;
	}

	static class Virus {
		int x;
		int y;
		int cnt;

		public Virus(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
