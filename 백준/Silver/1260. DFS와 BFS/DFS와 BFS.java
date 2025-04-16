
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int V;
	static boolean[][] board;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정점의 개수 N
		N = Integer.parseInt(st.nextToken());
		// 간선의 개수 M
		M = Integer.parseInt(st.nextToken());
		// 탐색을 시작할 정점의 번호 V
		V = Integer.parseInt(st.nextToken());

		board = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			board[x][y] = true;
			board[y][x] = true;
		}

		dfs();

		bfs();

	}

	private static void dfs() {
		StringBuilder sb = new StringBuilder();
		boolean[] visit = new boolean[N + 1];

		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(V);
		visit[V] = true;
		sb.append(V);

		while (!stack.isEmpty()) {
			int number = stack.peek();
			boolean flag = false;
			for (int j = 0; j < N+1; j++) {
				if(!visit[j] && board[number][j]) {
					stack.push(j);
					visit[j] = true;
					sb.append(" " + j);
					flag = true;
					break;
				}
			}
			if(!flag) {
				stack.pop();
			}

		}

		System.out.println(sb.toString());
	}

	private static void bfs() {
		StringBuilder sb = new StringBuilder();
		boolean[] visit = new boolean[N + 1];
		
		Queue<Integer> queue = new LinkedList();
		queue.add(V);
		visit[V] = true;
		sb.append(V);
		
		while (!queue.isEmpty()) {
			int number =  queue.poll();
			for (int j = 0; j < N+1; j++) {

				if(!visit[j] && board[number][j]) {
					queue.add(j);
					visit[j] = true;
					sb.append(" " + j);
				}
				
			}
		}

		System.out.println(sb.toString());

	}

}

//첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
//다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

