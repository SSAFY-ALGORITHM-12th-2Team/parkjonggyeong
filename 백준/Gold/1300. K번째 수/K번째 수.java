import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 1;
        long right = (long) N * N;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = count(mid, N);

            if (count >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static long count(long x, int N) {
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(x / i, N);
        }
        return cnt;
    }
}
