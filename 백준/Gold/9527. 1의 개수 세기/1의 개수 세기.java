import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long result = countBits(b) - countBits(a - 1);
        System.out.println(result);
    }
    
    private static long countBits(long n) {
        if (n <= 0) return 0;

        long k = largestPowerOf2(n);
        long count = k * (1L << (k - 1)) + (n - (1L << k) + 1) + countBits(n - (1L << k));

        return count;
    }
    
    private static long largestPowerOf2(long n) {
        long k = 0;
        while ((1L << k) <= n) {
            k++;
        }
        return k - 1;
    }
}
