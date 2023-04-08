
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[] dr = { 0, 1, -1, 0, 1, 1, -1, -1 };
	static int[] dc = { 1, 0, 0, -1, 1, -1, 1, -1 };
	static int[] d = {};
	// 매년 더 해지는 양분
	static int[][] A;
	// 현재 양분
	static int[][] board;

	// 나무들
	static List<Tree> trees = new LinkedList<>();
	static List<Tree> deadTrees = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				board[i][j] = 5;
			}
		}
		// 나무
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			trees.add(new Tree(x, y, z));
		}

		dfs();
		System.out.println(trees.size());

	}

	static void dfs() {
		Collections.sort(trees, (tree1, tree2) -> tree1.z - tree2.z);

		for (int i = 0; i < K; i++) {

			spring();
			summer();
			fall();
			winter();
		}
	}

	static void spring() {
		for (Iterator<Tree> iter = trees.iterator(); iter.hasNext();) {
			Tree tree = iter.next();

			if (board[tree.x - 1][tree.y - 1] >= tree.z) {
				board[tree.x - 1][tree.y - 1] -= tree.z;
				tree.z += 1;
				continue;
			}
			deadTrees.add(tree);
			iter.remove();
		}

	}

	static void summer() {
		for (Tree tree : deadTrees) {
			board[tree.x - 1][tree.y - 1] += (int) (tree.z / 2);
		}

		deadTrees = new ArrayList<>();
	}

	static void fall() {
		int treeCount = trees.size();
		List<Tree> newTrees = new LinkedList<>();
		for (Tree tree : trees) {

			if (tree.z % 5 != 0) {
				continue;
			}

			for (int d = 0; d < 8; d++) {
				int dx = tree.x + dr[d] - 1;
				int dy = tree.y + dc[d] - 1;

				if (dx >= 0 && dx < N && dy >= 0 && dy < N) {
					newTrees.add(new Tree(dx + 1, dy + 1, 1));
				}
			}
		}

		newTrees.addAll(trees);
		trees = newTrees;
	}

	static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] += A[i][j];
			}
		}

	}

	static class Tree {
		int x;
		int y;
		int z;

		public Tree(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", z=" + z + "]";
		}

	}

}
