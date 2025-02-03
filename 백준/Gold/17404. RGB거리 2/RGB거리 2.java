import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rgbs = new int[n][3];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            rgbs[i][0] = Integer.parseInt(st.nextToken());
            rgbs[i][1] = Integer.parseInt(st.nextToken());
            rgbs[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, rgbs));
        br.close();
    }

    public static int solution(int n, int[][] rgbs) {
        int answer = INF;

        for (int initialColor = 0; initialColor < 3; initialColor++) {
            int[][] dp = new int[n][3];

            for (int color = 0; color < 3; color++) {
                dp[0][color] = (color == initialColor) ? rgbs[0][color] : INF;
            }

            for (int house = 1; house < n; house++) {
                dp[house][0] = Math.min(dp[house - 1][1], dp[house - 1][2]) + rgbs[house][0];
                dp[house][1] = Math.min(dp[house - 1][0], dp[house - 1][2]) + rgbs[house][1];
                dp[house][2] = Math.min(dp[house - 1][0], dp[house - 1][1]) + rgbs[house][2];
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor != initialColor) {
                    answer = Math.min(answer, dp[n - 1][lastColor]);
                }
            }
        }

        return answer;
    }
}
