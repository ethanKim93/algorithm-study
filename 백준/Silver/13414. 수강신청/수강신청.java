import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 수강 가능 인원
        int L = Integer.parseInt(st.nextToken()); // 대기 목록 길이

        LinkedHashSet<String> students = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String studentId = br.readLine();
            students.remove(studentId); // 중복 제거 (가장 마지막 신청만 유효)
            students.add(studentId);
        }

        // 결과 출력 (K명까지만)
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (String id : students) {
            sb.append(id).append("\n");
            count++;
            if (count == K) break; // K명까지만 출력
        }

        System.out.print(sb);
    }
}
