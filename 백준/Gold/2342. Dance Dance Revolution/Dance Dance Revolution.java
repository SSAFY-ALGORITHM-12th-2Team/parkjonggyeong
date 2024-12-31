import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer> sol;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        sol = new ArrayList<>();
        while (true) {
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) {
                break;
            }
            sol.add(input);
        }
        dp = new int[5][5][sol.size() + 1];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k <= sol.size(); k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(dfs(0,0,0));
    }

    private static int dfs(int right, int left, int depth) {
        if(depth == sol.size()){
            return 0;
        }
        if (dp[right][left][depth] != -1) {
            return dp[right][left][depth];
        }
        int rightP = dfs(sol.get(depth), left, depth + 1) + pump(right, sol.get(depth));
        int leftP = dfs(right, sol.get(depth), depth + 1) + pump(left, sol.get(depth));
        dp[right][left][depth] = Math.min(rightP, leftP);

        return dp[right][left][depth];
    }

    public static int pump(int start, int end) {
        if (start == 0) {
            return 2;
        } else if (Math.abs(start - end) == 2) {
            return 4;
        } else if (start == end) {
            return 1;
        } else {
            return 3;
        }
    }
}