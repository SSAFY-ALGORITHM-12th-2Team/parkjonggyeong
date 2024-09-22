import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int n, dp[];

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 3;
    for (int i = 2; i <= n; i++) {
      dp[i] = (dp[i -1] * 2 + dp[i -2]) % 9901;
    }
    System.out.println(dp[n]);
  }
}
