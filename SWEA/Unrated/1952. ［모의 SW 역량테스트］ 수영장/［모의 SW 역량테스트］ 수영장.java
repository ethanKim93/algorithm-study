/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
			/*
		 * ① 1일 이용권 : 1일 이용이 가능하다. ② 1달 이용권 : 1달 동안 이용이 가능하다. 1달 이용권은 매달 1일부터 시작한다. ③ 3달
		 * 이용권 : 연속된 3달 동안 이용이 가능하다. 3달 이용권은 매달 1일부터 시작한다. (11월, 12월에도 3달 이용권을 사용할 수 있다
		 * / 다음 해의 이용권만을 구매할 수 있기 때문에 3달 이용권은 11월, 12월, 1윌 이나 12월, 1월, 2월 동안 사용하도록 구매할
		 * 수는 없다.) ④ 1년 이용권 : 1년 동안 이용이 가능하다. 1년 이용권은 매년 1월 1일부터 시작한다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dayValue = Integer.parseInt(st.nextToken());
			int monthValue = Integer.parseInt(st.nextToken());
			int threeMonthValue = Integer.parseInt(st.nextToken());
			int yearValue = Integer.parseInt(st.nextToken());

			int[] usePlans = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] monthPays = new int[12];

			for (int i = 0; i < 12; i++) {

				int dayPays = usePlans[i] * dayValue;
				if (i == 0) {
					monthPays[i] = Math.min(monthValue, dayPays);
					continue;
				}
				monthPays[i] = monthPays[i - 1] + Math.min(monthValue, dayPays);

				if (i >= 2) {
					int prePay = 0;
					if(i!=2) {
						prePay = monthPays[i - 3] ;
					}
					if ( prePay + threeMonthValue<= monthPays[i]) {
						for (int j = i - 2; j <= i; j++) {
							monthPays[j] = Math.min(monthPays[j], prePay + threeMonthValue);
						}
					}
				}

			}
//			System.out.println(Arrays.toString(monthPays));
			System.out.println("#" + tc + " " + Math.min(monthPays[11], yearValue));
		}
	}
}