import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] board;
	static int[] choosePeople;
	static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/*
		 * 구현 해야 하는것 팀을 나누는 조합, ex) 6명중 3명을 택하기 , (나머지는 자동 팀) 0 이면 바로 return
		 * 
		 */
		ArrayList<Integer> temp = new ArrayList<Integer>();
		selectPeople(0, 0,temp);
		System.out.println(minValue);

	}

	// 조합
	static void selectPeople(int start, int cnt, ArrayList<Integer> team) {
		if (team.size() == N / 2) {
			comPareTeam(team);
			return;
		}

		for (int i = start; i < N; i++) {
			ArrayList<Integer> temp = (ArrayList<Integer>) team.clone();
			temp.add(i);
			selectPeople(i + 1, cnt + 1, temp);
		}
	}

	static void comPareTeam(ArrayList<Integer> team) {
		int start = 0;
		int link = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (team.contains(i) && team.contains(j))
					start += board[i][j];
				else if (!team.contains(i) && !team.contains(j))
					link += board[i][j];
			}
		}

		int temp = Math.abs(start - link);
		if (minValue > temp) {
			minValue = temp;
		}
	}
}
