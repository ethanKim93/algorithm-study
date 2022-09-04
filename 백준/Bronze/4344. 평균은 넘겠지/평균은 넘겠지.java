import java.util.Scanner;
import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int C = sc.nextInt();

		for (int tc = 0; tc < C; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			float sumResult = 0 ;
			for (int i = 0; i < N; i++) {
				int grade = sc.nextInt();
				arr[i] = grade;
				sumResult += grade;
			}

			float avr = sumResult / N;
			float cnt = 0;
			for (int j = 0; j < N; j++) {
				if(arr[j] > avr) {
					cnt += 1;
				}
			}
			float answer = (cnt/N)*100; 
			System.out.printf("%.3f%%\n",answer);
		}

		sc.close();

	}

}
