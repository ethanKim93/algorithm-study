import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		float[] arr = new float[N];
		
		for(int i = 0 ; i <N; i ++) {
			arr[i] = sc.nextFloat();
		}
		
		sc.close();
		
		Arrays.sort(arr);
		float sumResult = 0;
		for (float j : arr) {
			sumResult += (j/arr[N-1])*100;
		}
		
		System.out.println(sumResult/N);
	}

}
