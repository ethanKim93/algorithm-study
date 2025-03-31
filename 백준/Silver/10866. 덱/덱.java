
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> deque = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			String cmd = st.nextToken();
			switch (cmd) {
			case "push_front": {
				deque.add(0, st.nextToken());
				break;
			}
			case "push_back": {
				deque.add(st.nextToken());
				break;
			}
			case "pop_front": {
				if (!deque.isEmpty()) {
					System.out.println(deque.get(0));
					deque.remove(0);
				} else {
					System.out.println(-1);
				}
				break;
			}
			case "pop_back": {
				if (!deque.isEmpty()) {
					int listLegnth = deque.size() - 1;
					System.out.println(deque.get(listLegnth));
					deque.remove(listLegnth);
				} else {
					System.out.println(-1);
				}
				break;
			}
			case "size": {
				System.out.println(deque.size());
				break;
			}
			case "empty": {
				if (deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}

				break;

			}
			case "front": {
				if (!deque.isEmpty()) {
					System.out.println(deque.get(0));
				} else {
					System.out.println(-1);
				}
				break;
			}
			case "back": {
				if (!deque.isEmpty()) {
					int listLegnth = deque.size() - 1;
					System.out.println(deque.get(listLegnth));
				} else {
					System.out.println(-1);
				}
				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + cmd);
			}

		}

	}

}
