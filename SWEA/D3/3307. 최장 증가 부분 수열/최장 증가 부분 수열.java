import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine()); // 수열의 길이
            int[] grid = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int n = 0; n < N; n++) {
                grid[n] = Integer.parseInt(st.nextToken());
            }

            int result = longestIncreasingSubsequence(grid);
            System.out.println("#" + t + " " + result);
        }
    }

    private static int longestIncreasingSubsequence(int[] arr) {
        int N = arr.length;
        int[] lis = new int[N]; // LIS 길이를 저장할 배열

        // 모든 요소의 LIS 길이를 1로 초기화
        Arrays.fill(lis, 1);

        // LIS 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // LIS 길이의 최댓값을 찾기
        int maxLIS = 0;
        for (int length : lis) {
            maxLIS = Math.max(maxLIS, length);
        }

        return maxLIS;
    }
}
