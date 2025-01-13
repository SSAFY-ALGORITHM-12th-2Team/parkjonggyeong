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
        
        long highestBit = Long.highestOneBit(n);
        long bitCount = (highestBit >> 1) * Long.bitCount(highestBit - 1) + (n - highestBit + 1) + countBits(n - highestBit);
        return bitCount;
    }
}
