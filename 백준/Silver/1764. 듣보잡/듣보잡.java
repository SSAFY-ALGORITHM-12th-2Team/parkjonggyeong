import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static HashSet<String> lis;
    static ArrayList<String> look;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lis = new HashSet<>(); // HashSet으로 변경
        look = new ArrayList<>();

        // lis 배열 입력
        for (int i = 0; i < n; i++) {
            lis.add(br.readLine());
        }

        // look 배열 입력 및 검사
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            if (lis.contains(input)) { // HashSet에서 존재 여부 확인
                look.add(input);
            }
        }

        // 출력
        System.out.println(look.size());
        Collections.sort(look);
        for (String l : look) {
            System.out.println(l);
        }
    }
}
