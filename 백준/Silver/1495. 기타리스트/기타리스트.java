import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s, m, v[];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        v = new int[n + 1];
        dp = new int[n + 1][m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][s] = 1;

        int result = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j] == 1) {
                    if (j + v[i] <= m) {
                        dp[i][j + v[i]] = 1;
                    }

                    if (j - v[i] >= 0) {
                        dp[i][j - v[i]] = 1;
                    }
                }
            }
        }

        for (int j = 0; j <= m; j++) {
            if(dp[n][j] == 1){
                result = Math.max(j, result);
            }
        }

        System.out.println(result);
    }
}
