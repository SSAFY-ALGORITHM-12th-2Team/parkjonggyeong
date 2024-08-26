import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1000000;
    static int[] num = new int[100001], pos = new int[100001];
    static int n, x, ans;
    static int pole1, pole2, pole3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cal(n);  // 2의 제곱을 계산

        StringTokenizer st = new StringTokenizer(br.readLine());
        pole1 = Integer.parseInt(st.nextToken());
        pole2 = Integer.parseInt(st.nextToken());
        pole3 = Integer.parseInt(st.nextToken());

        // 원판의 위치 기록
        if (pole1 > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < pole1; i++) {
                x = Integer.parseInt(st.nextToken());
                pos[x] = 1;
            }
        }

        if (pole2 > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < pole2; i++) {
                x = Integer.parseInt(st.nextToken());
                pos[x] = 2;
            }
        }

        if (pole3 > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < pole3; i++) {
                x = Integer.parseInt(st.nextToken());
                pos[x] = 3;
            }
        }

        hanoi(n, pos[n]);

        System.out.println(pos[n]);
        System.out.println(ans);
    }

    static void cal(int n) {
        num[0] = 1;
        for (int i = 1; i <= n; i++) {
            num[i] = (num[i - 1] * 2) % MOD;
        }
    }

    static void hanoi(int disc, int to) {
        if (disc == 0) return;

        int now = pos[disc]; // 현재 원판의 위치
        int sub = 0; // 보조 막대기

        for (int i = 1; i <= 3; i++) {
            if (now != i && to != i) {
                sub = i;
            }
        }

        if (now == to) {
            hanoi(disc - 1, to);
        } else {
            ans = (ans + num[disc - 1]) % MOD;
            hanoi(disc - 1, sub);
        }
    }
}
