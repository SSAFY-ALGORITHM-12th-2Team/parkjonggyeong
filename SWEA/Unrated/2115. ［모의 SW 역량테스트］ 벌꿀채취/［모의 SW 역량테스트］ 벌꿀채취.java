import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    static int T, n, m, c, bee[][], maxProfit;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 벌통 크기
            m = Integer.parseInt(st.nextToken()); // 벌통 개수
            c = Integer.parseInt(st.nextToken()); // 최대 채취량

            bee = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    bee[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            maxProfit = 0;
            // 첫 번째 일꾼이 선택하는 벌통 위치를 결정
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - m; j++) {
                    int profit1 = getMaxProfit(i, j); // 첫 번째 일꾼의 최대 수익 계산
                    // 두 번째 일꾼의 벌통 위치를 결정 (겹치지 않도록)
                    for (int x = i; x < n; x++) {
                        for (int y = (x == i ? j + m : 0); y <= n - m; y++) {
                            int profit2 = getMaxProfit(x, y); // 두 번째 일꾼의 최대 수익 계산
                            maxProfit = Math.max(maxProfit, profit1 + profit2);
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + maxProfit);
        }
    }

    // 특정 시작 위치에서 m개의 벌통에서 최대 이익을 구하는 함수
    private static int getMaxProfit(int row, int col) {
        int[] selected = new int[m];
        for (int i = 0; i < m; i++) {
            selected[i] = bee[row][col + i];
        }

        return getMaxSubsetProfit(selected, 0, 0, 0);
    }

    // 부분집합을 이용해 최대 이익을 구하는 함수
    private static int getMaxSubsetProfit(int[] selected, int idx, int currentSum, int currentProfit) {
        if (currentSum > c) return 0;
        if (idx == m) return currentProfit;
        
        // 선택하지 않는 경우
        int profitWithoutCurrent = getMaxSubsetProfit(selected, idx + 1, currentSum, currentProfit);
        // 선택하는 경우
        int profitWithCurrent = getMaxSubsetProfit(selected, idx + 1, currentSum + selected[idx], currentProfit + selected[idx] * selected[idx]);

        return Math.max(profitWithoutCurrent, profitWithCurrent);
    }
}
