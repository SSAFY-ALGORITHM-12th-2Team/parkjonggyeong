import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int result = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    for (int i = 0; i < n; ++i) {
      int findNum = arr[i];
      int left = 0;
      int right = n - 1;

      while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == findNum) {
          if (i == left) {
            ++left;
          } else if (right == i) {
            --right;
          } else {
            ++result;
            break;
          }
        }

        if (sum > findNum) {
          --right;
        } else if (sum < findNum) {
          ++left;
        }
      }
    }

    System.out.println(result);
  }
}
