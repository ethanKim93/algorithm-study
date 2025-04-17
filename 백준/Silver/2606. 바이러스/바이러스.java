import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[][] board = new boolean[N+1][N+1];
		boolean[] visit = new boolean[N+1];
		
		for(int i = 0 ; i < M ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int computer1 = Integer.parseInt(st.nextToken());
			int computer2 = Integer.parseInt(st.nextToken());

			board[computer1][computer2] = true;
			board[computer2][computer1] = true;
			
			
		}
		
		Deque<Integer> stack = new LinkedList<>();
		
		int result = 0;
		
		//1번 부터 시작
		stack.push(1);
		visit[1] = true;
		
		while (!stack.isEmpty()) {
			
			int com1 = stack.peek();
			boolean flag = false;
			
			for(int j = 1; j < N+1 ; j++) {
				
				if(!visit[j] && board[com1][j]) {
					stack.push(j);
					visit[j] = true;
					result ++;
					flag= true;
					break;
				}
			}
			if(!flag) {
				stack.pop();
			}
			
		}
		
		
		System.out.println(result);

	}

}