import java.io.*;
import java.util.*;

public class Solution {
    static int n, sum, person[][], company[], home[], min, result;
    static boolean visit[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            company = new int[2];
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());

            home = new int[2];
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            person = new int[n][2];
            for (int i = 0; i < n; i++) {
                person[i][0] = Integer.parseInt(st.nextToken());
                person[i][1] = Integer.parseInt(st.nextToken());
            }
            result = Integer.MAX_VALUE;
            visit = new boolean[n];
            dfs(company[0], company[1], 0, 0);

            bw.write("#" + t + " " + result + "\n");
        }
            bw.flush();
            bw.close();
            br.close();
        
    }

    private static void dfs(int x, int y, int sum, int idx) {
        if (idx == n) {
            sum += Math.abs(x - home[0]) + Math.abs(y - home[1]);
            result = Math.min(result, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(person[i][0], person[i][1], sum + Math.abs(x - person[i][0]) + Math.abs(y - person[i][1]), idx + 1);
                visit[i] = false;
            }
        }
    }
}

