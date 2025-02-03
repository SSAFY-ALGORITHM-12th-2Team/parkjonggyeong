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
        int[][] dp = new int[n][3];

        for (int initialColor = 0; initialColor < 3; initialColor++) {
            for (int color = 0; color < 3; color++) {
                dp[0][color] = (initialColor == color) ? rgbs[0][color] : INF;
            }

            for (int house = 1; house < n; house++) {
                for (int currentColor = 0; currentColor < 3; currentColor++) {
                    dp[house][currentColor] = INF;
                    for (int prevColor = 0; prevColor < 3; prevColor++) {
                        if (currentColor != prevColor) {
                            dp[house][currentColor] = Math.min(dp[house][currentColor], dp[house - 1][prevColor] + rgbs[house][currentColor]);
                        }
                    }
                }
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (initialColor != lastColor) {
                    answer = Math.min(answer, dp[n - 1][lastColor]);
                }
            }
        }

        return answer;
    }
}
