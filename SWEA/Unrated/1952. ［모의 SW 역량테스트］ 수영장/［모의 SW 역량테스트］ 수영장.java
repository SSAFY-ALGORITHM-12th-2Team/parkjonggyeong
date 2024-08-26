import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    static int T, day, month, threemonth, year, arr[], result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            threemonth = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());

            arr = new int[12];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = year;
            dfs(0, 0);
            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs(int m, int sum) {
        //1년권보다 높으면 버린다.
        if (result <= sum) {
            return;
        }
        if (m > 11) {
            result = Math.min(result, sum);
            return;
        }

        if (arr[m] == 0) {
            dfs(m + 1, sum);
        } else {
            //1일권
            dfs(m + 1, sum + day * arr[m]);
            //1달권
            dfs(m + 1, sum + month);
            //3달권
            dfs(m + 3, sum + threemonth);
        }
    }
}
