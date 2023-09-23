import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	// 연결 관계
	static int[][] circles = {
			{0,2,0,0},
			{6,0,2,0},
			{0,6,0,2},
			{0,0,6,0},
	};
	
	// 시계 방향 회전
	public static String[] cwArr(String[] originArr) {
		String[] targetArr = new String[originArr.length];
		
		targetArr[0] = originArr[originArr.length-1];
		for(int i = 0; i < originArr.length -1 ; i++) {
			targetArr[i+1] = originArr[i];
		}
		
		return targetArr;
	}
	
	// 반시계방향 회전
	public static String[] ccwArr(String[] originArr) {
		
		String[] targetArr = new String[originArr.length];
		for(int i = 1; i < originArr.length ; i++) {
			targetArr[i-1] = originArr[i];
		}
		targetArr[originArr.length-1] = originArr[0];
		
		return targetArr;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
//		
//		String[] first = br.readLine().split("");
//		String[] two = br.readLine().split("");
//		String[] three = br.readLine().split("");
//		String[] four = br.readLine().split("");
//		
		List<String[]> clocks = new ArrayList<>();
		for(int i = 0; i < 4;i++) {
			clocks.add(br.readLine().split(""));
		}
		
		
//		System.out.println("start clocks");
//		for(String[] clock : clocks) {
//			System.out.print(Arrays.deepToString(clock));
//		}
		
		int K = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < K ; tc ++) {
//			System.out.println("tc : " + tc);

			//첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다. 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int selectCircle = Integer.parseInt(st.nextToken()) - 1;
			int selectDir = Integer.parseInt(st.nextToken());
//			System.out.println(String.format("selectCircle : %d selectDir : %d  ",selectCircle,selectDir));

			// 톱니 바퀴 방향 저장
			int[] dirs = new int[4];
			Arrays.fill(dirs, 0);
			
			dirs[selectCircle] = selectDir;
			
			//오른쪽 
			for(int i = selectCircle; i < 4 ;i ++ ){

				if(i == selectCircle) {
					continue;
				}
				// 이전 값이 회전하지 않았다면,
				if(dirs[i-1] == 0) {
					continue;
				}
				String[] preClock = clocks.get(i-1);
				String[] nextClock = clocks.get(i);
				
				if(preClock[2].equals(nextClock[6])) {
					continue;
				}
				
				dirs[i] = dirs[i-1] * -1;
			}
			
			//왼쪽 
			for(int i = selectCircle; i > -1 ;i -- ){

				if(i == selectCircle) {
					continue;
				}
				// 이전 값이 회전하지 않았다면,
				if(dirs[i+1] == 0) {
					continue;
				}
				String[] preClock = clocks.get(i+1);
				String[] nextClock = clocks.get(i);
				
				if(preClock[6].equals(nextClock[2])) {
					continue;
				}
				
				dirs[i] = dirs[i+1] * -1;
			}	
			
			
			for(int i = 0; i < 4 ; i ++) {
				if(dirs[i]==0) {
					continue;
				}
				String[] clock = clocks.get(i);
				if(dirs[i] == 1) {
					clocks.set(i,  cwArr(clock));
					continue;
				}
				clocks.set(i, ccwArr(clock));
			}

//			for(String[] clock : clocks) {
//				System.out.print(Arrays.deepToString(clock));
//			}
//			System.out.println();
		}

//		System.out.println("end clocks");
//		System.out.println(clocks.toString());
		int answer = 0;
		for(int i = 0 ; i < 4 ; i ++ ) {
			if(clocks.get(i)[0].equals("1"))
				answer += Math.pow(2,i);
		}
		System.out.println(answer);

//		for(String[] clock : clocks) {
//			System.out.print(Arrays.deepToString(clock));
//		}
//		System.out.println();

	}

}
