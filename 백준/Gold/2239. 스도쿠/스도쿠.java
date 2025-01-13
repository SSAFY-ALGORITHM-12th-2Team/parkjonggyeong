import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }
        backtracking(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void backtracking(int num) {
        if (num == 81) {
            flag = true;
            return;
        }
        int r = num / 9;
        int c = num % 9;
        if (board[r][c] != 0) {
            backtracking(num + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isValid(r, c, i)) {
                    board[r][c] = i;
                    backtracking(num);
                    if (flag) {
                        return;
                    }
                    board[r][c] = 0;
                }
            }
        }
    }

    private static boolean isValid(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num || board[i][c] == num) {
                return false;
            }
        }
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[sr + i][sc + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
