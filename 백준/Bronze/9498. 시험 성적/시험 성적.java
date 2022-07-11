import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int grade = sc.nextInt();
		String ans = "";
		if(grade >= 90) {
			ans = "A";
		}
		else if(grade >= 80) {
			ans = "B";
		}
		else if(grade >= 70) {
			ans = "C";
		}
		else if(grade >= 60) {
			ans = "D";
		}
		else {
			ans = "F";
		}
		
		System.out.print(ans);
	}

}
