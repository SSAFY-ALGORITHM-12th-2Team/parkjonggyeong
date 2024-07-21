import java.util.*;
import java.io.*;

public class Solution {
    static int[] dx = {-1, 1, 0, 1, -1, 1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

    static int board[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            board = new int[n][n];

            board[n / 2][n / 2] = 2;
            board[n / 2 - 1][n / 2] = 1;
            board[n / 2][n / 2 - 1] = 1;
            board[n / 2 - 1][n / 2 - 1] = 2;

            int cnt1 = 0;
            int cnt2 = 0;

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int color = sc.nextInt();

                board[x - 1][y - 1] = color;
                O(x - 1, y - 1, n, color);

            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        cnt1++;
                    } else if(board[i][j] == 2){
                        cnt2++;
                    }
                }
            }

            System.out.println("#" + t + " " + cnt1 + " " + cnt2);
        }
    }

    static void O(int x, int y, int n, int color) {


        for (int i = 0; i < 4; i++) {
            for(int j =0; j< 4; j++){
                int nx = x + dx[i];
                int ny = y + dy[j];
                boolean check = false;

                while (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] != 0) {
                    if (board[nx][ny] == color) {
                        check = true;
                        break;
                    }
                    nx += dx[i];
                    ny += dy[j];
                }
                while (check) {
                    if (nx == x && ny == y) {
                        break;
                    }
                    board[nx][ny] = color;
                    nx -= dx[i];
                    ny -= dy[j];
                }
            }

        }
    }
}
