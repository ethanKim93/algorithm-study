import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		System.out.print(solution(num));
	}
	
	static int solution(int num) {
		int cnt = 0;
		for(int i=1;i<=num;i++) {
			boolean flag = true;
			int temp_i = i;
			int temp = -11;
			while(temp_i > 0) {
				int namugi1 = temp_i % 10;
				temp_i /= 10;
				int namugi2 = temp_i % 10;
				if (temp == -11) {
					temp = namugi1 - namugi2;
				}
				else if(temp_i == 0) {
					break;
				}
				else if(temp != namugi1 - namugi2){
					flag = false;
					break;
				}
			}
			if (flag) {
				cnt += 1;

			}
		}
		return cnt;
	}

}
