
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, k;
	static int[][] board;
	static int[][] smellNumber;
	static List<Shark> sharks = new ArrayList<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		smellNumber = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n != 0) {
					sharks.add(new Shark(i, j, n));
					board[i][j] = k;
				}
			}
		}
		Collections.sort(sharks, (s1, s2) -> s1.number - s2.number);

		int[] startDir = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			startDir[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		for (Shark shark : sharks) {
			shark.setDir(startDir[shark.number - 1]);
			HashMap<Integer, int[]> priority = new HashMap<>();
			for (int i = 0; i < 4; i++) {
				int[] ps = new int[4];
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					ps[j] = Integer.parseInt(st.nextToken()) - 1;
				}
				priority.put(i, ps);
			}
			shark.setPriority(priority);
		}
//		System.out.println(sharks);
		int answer = dfs();
		System.out.println(answer);
	}

	static int dfs() {
		int second = 1;
		while (second < 1001) {

			// 자신의 냄새 뿌리기
			for (Shark shark : sharks) {
				board[shark.x][shark.y] = k;
				smellNumber[shark.x][shark.y] = shark.number;

			}

			// 이동하기
			moveShark();
			// 작은 번호가 쫓아 내기
			boolean[][] outShark = new boolean[N][N];
//			System.out.println(Arrays.deepToString(outShark));
			for (Iterator<Shark> iter = sharks.iterator(); iter.hasNext();) {
				Shark shark = iter.next();
				if (!outShark[shark.x][shark.y]) {
					outShark[shark.x][shark.y] = true;
				} else {
					iter.remove();
				}

			}

			// 상어가 1만 남으면
//			System.out.println(second + " " + sharks.size());
//			System.out.println(sharks);
			if (sharks.size() == 1) {
				return second;
			}

			// 전체 냄새 1 감소
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] != 0) {
						board[i][j] -= 1;
						if (board[i][j] == 0) {
							smellNumber[i][j] = 0;
						}
					}

				}
			}
			second += 1;
		}
		return -1;
	}

	static void moveShark() {

		for (Shark shark : sharks) {
			List<Integer> emptys = new ArrayList<>();
			List<Integer> mySmells = new ArrayList<>();
			List<Integer> candidate;

			// 주변에 냄새가 없는곳 찾기
			for (int d = 0; d < 4; d++) {
				int dx = shark.x + dr[d];
				int dy = shark.y + dc[d];

				if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
					if (board[dx][dy] == 0) {
						emptys.add(d);
					} else if (smellNumber[dx][dy] == shark.number) {
						mySmells.add(d);
					}
				}

			}
			// 없다면 자신의 냄새 있는곳 찾기
			candidate = emptys.size() != 0 ? emptys : mySmells;
			// 찾은 칸 중 우선 순위 판단하기
			if (candidate.size() != 0) {
				int selectDir = -1;
				int[] prioritys = shark.priority.get(shark.dir);
				try {
					for (int p : prioritys) {
						if (candidate.contains(p)) {
							selectDir = p;
							break;
						}
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				// 이동하기
				try {
					shark.x += dr[selectDir];
					shark.y += dc[selectDir];
					shark.dir = selectDir;
				} catch (Exception e) {
					System.out.println(e.toString());
				}

			}
		}

	}

	static class Shark {
		int x, y, number, dir;
		HashMap<Integer, int[]> priority;

		public Shark(int x, int y, int number) {
			super();
			this.x = x;
			this.y = y;
			this.number = number;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getNumber() {
			return number;
		}

		public int getDir() {
			return dir;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public HashMap<Integer, int[]> getPriority() {
			return priority;
		}

		public void setPriority(HashMap<Integer, int[]> priority) {
			this.priority = priority;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", number=" + number + "]";
		}

	}
}
