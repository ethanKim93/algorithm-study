import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static ArrayList<FireBall> fireBalls = new ArrayList<FireBall>();
	static ArrayList<FireBall>[][] fireMap;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
//	static int[][] board;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fireMap = new ArrayList[N][N];

		for (int a = 0; a < N; a++) {
			for (int b = 0; b < N; b++) {
				fireMap[a][b] = new ArrayList<FireBall>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			FireBall fb = new FireBall(r, c, m, s, d);
			fireBalls.add(fb);
		}

		for (int q = 0; q < K; q++) {
//			System.out.println(fireBalls.toString());
//			System.out.println(Arrays.deepToString(fireMap));
			
			move();
			
//			System.out.println(fireBalls.toString());
//			System.out.println(Arrays.deepToString(fireMap));
			
			checkFireBall();
//			System.out.println(fireBalls.toString());
//			System.out.println(Arrays.deepToString(fireMap));

		}
		int answer = 0;
		for (FireBall fb : fireBalls) {
//			System.out.println(fb.m);
			answer += fb.m;
		}
		System.out.println(answer);
	}

	static void move() {
		for (FireBall fb : fireBalls) {
			int dr = (fb.r + N + dx[fb.d] * (fb.s % N)) % N;
			int dc = (fb.c + N + dy[fb.d] * (fb.s % N)) % N;
			fb.r = dr;
			fb.c = dc;
			fireMap[dr][dc].add(fb);
		}
	}

	static void checkFireBall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (fireMap[i][j].size() == 1)
					fireMap[i][j].clear();
				
				if (fireMap[i][j].size() < 2)
					continue;

				int totalM = 0;
				int totalS = 0;
				
				boolean odd = fireMap[i][j].get(0).d % 2 == 0 ? true : false;
				boolean even = fireMap[i][j].get(0).d % 2 == 1 ? true : false;

				for (FireBall fb : fireMap[i][j]) {
					totalM += fb.m;
					totalS += fb.s;
					odd = odd & fb.d % 2 == 0 ? true : false;
					even = even & fb.d % 2 == 1 ? true : false;
					fireBalls.remove(fb);
				}
				
	
				int addM = totalM / 5;
				int addS = totalS / fireMap[i][j].size();
				fireMap[i][j].clear();

				if (addM == 0)
					continue;
				
				if (even | odd) {
					for (int k = 0; k < 8; k += 2) {
						FireBall fb2 = new FireBall(i, j, addM, addS, k);
						fireBalls.add(fb2);
					}
				} else {
					for (int k = 1; k < 8; k += 2) {
						fireBalls.add(new FireBall(i, j, addM, addS, k));
					}
				}

			}
		}
	}
}

class FireBall {
	int r;
	int c;
	int m;
	int s;
	int d;

	public FireBall(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}

	@Override
	public String toString() {
		return "FireBall [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
	}
}
