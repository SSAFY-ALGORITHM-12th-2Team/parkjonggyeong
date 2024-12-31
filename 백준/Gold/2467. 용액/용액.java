import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] sol;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        sol = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            sol[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = n - 1;
        int max = Integer.MAX_VALUE;
        int sol1 = 0;
        int sol2 = 0;

        while (left < right) {
            int sum = sol[left] + sol[right];
            if (Math.abs(sum) < max) {
                max = Math.abs(sum);
                sol1 = sol[left];
                sol2 = sol[right];

            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }

        }
        System.out.println(sol1 + " " + sol2);
    }
}