import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

//	현재 칸이 아직 청소되지 않은 경우, 
//		현재 칸을 청소한다.
//	현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
//		바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
//		바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
//	현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
//		반시계 방향으로 $90^\circ$ 회전한다.
//		바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
//		1번으로 돌아간다.
	
// 입력 : N ,M 
// 출력 : 청소하는 칸의 갯수
	
	static int[] dx  = {-1,0,1,0};
	static int[] dy  = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
	
		int[][] maps = new int[N][M];	
		Boolean[][] visit = new Boolean[N][M];
		
		
		st = new StringTokenizer(br.readLine());
		
		int r =Integer.parseInt(st.nextToken());
		int c =Integer.parseInt(st.nextToken()); 
		int d =Integer.parseInt(st.nextToken()); 
		
		// map 초기화
		for(int i = 0; i < N ; i ++ ) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(visit[i],false);
			for(int j = 0;j < M ; j ++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		int answer = 0;
		
		while(true) {
			
			//현재 칸이 아직 정소가 되지 않은 경우
			if(!visit[r][c]) {
				visit[r][c] = true;
//				System.out.println(Arrays.deepToString(visit));
				answer += 1;
				continue;
			}
			
			boolean flag = false;
			// 4방향중 청소 되지 않은 빈칸이 있는 경우
			for(int k = 1; k < 5; k++) {
				int dir = (4 + d - k)%4;
				int dr = r + dx[dir];
				int dc = c + dy[dir];
				
				//범위를 벗어나면
				if(dr < 0 || dr>=N || dc<0|| dc>=M) {
					continue;
				}
				//이미 청소 되었거나 벽이라면
				if(maps[dr][dc] == 1 || visit[dr][dc]) {
					continue;
				}
				
				//빈칸으로 전진
				r = dr;
				c = dc;
				d = dir;
				flag = true;
				break;
			}
			
			// 전진 했다면 1번으로
			if(flag) {
				continue;
			}
			
			// 4방향 중 청소 되지 않은 빈칸이 없는 경우
			// 후진 방향
			int dir = (d + 2)%4;
			
			int dr = r + dx[dir];
			int dc = c + dy[dir];
			//범위를 벗어나면
			if(dr < 0 || dr>=N || dc<0|| dc>=M) {
				break;
			}
			//벽이라면
			if(maps[dr][dc] == 1) {
				break;
			}
			r = dr;
			c = dc;
		}

		System.out.println(answer);
		
	}

}
