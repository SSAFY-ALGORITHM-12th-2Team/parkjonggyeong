
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
  static int T, result;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      int n = Integer.parseInt(br.readLine());
      int[] weight = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        weight[i] = Integer.parseInt(st.nextToken());
      }

      result = 0;
      dfs(0, 0, 0, weight, new boolean[n], n);
      System.out.println("#" + t + " " + result);
    }

  }

  private static void dfs(int left, int right, int cnt, int[] weight, boolean[] v, int n) {
    if(left < right){
      return;
    }
    if (cnt == n) {

      result++;

      return;
    }
    for (int i = 0; i < n; i++) {
      if (!v[i]) {
        v[i] = true;
        dfs(left + weight[i], right, cnt + 1, weight, v, n);
        if (left >= right + weight[i]) {
          dfs(left, right + weight[i], cnt + 1, weight, v, n);
        }
        v[i] = false;
      }
    }
  }
}
