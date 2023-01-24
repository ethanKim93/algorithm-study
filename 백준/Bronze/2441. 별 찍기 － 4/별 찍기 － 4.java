
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String answer = "";
			for (int j = 0; j < i; j++) {
				answer += " ";
			}
			
			for (int j = i; j < N; j++) {
				answer += "*";
			}
			System.out.println(answer);

		}
	}

}
