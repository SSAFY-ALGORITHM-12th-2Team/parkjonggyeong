import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        long area = 0L;
        for (int i =0; i < n; i++){
            int j = (i + 1) % n;
            area += ((long) x[i] * y[j]) - ((long) y[i] * x[j]);
        }
        System.out.printf("%.1f%n", Math.abs(area) / 2D);

    }
}