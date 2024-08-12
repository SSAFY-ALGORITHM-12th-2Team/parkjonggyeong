

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] n;
    static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static boolean[][] v;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        n = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                n[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //백트캐킹 문제
        bfs(0, 0);

    }

    private static void bfs(int r, int c) {
        if (c == 9) {
            bfs(r + 1, 0);
            return;
        }

        if (r == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(n[i][j] + " ");
                }
                System.out.println();

            }
            System.exit(0);
        }

        // 이문제 이거 아님 다돌고 0으로 돌려야하는거 아니야고 썅
        if (n[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(r, c, i)) {
                    n[r][c] = i;
                    bfs(r, c + 1);
                }
            }
            n[r][c] = 0;
            return;
        }
        bfs(r, c + 1);
    }

    private static boolean check(int r, int c, int d) {
        for (int i = 0; i < 9; i++) {
            if (n[r][i] == d) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (n[i][c] == d) {
                return false;
            }
        }
        int newR = (r / 3) * 3;
        int newC = (c / 3) * 3;

        for (int i = newR; i < newR + 3; i++) {
            for (int j = newC; j < newC + 3; j++) {
                if (n[i][j] == d) {
                    return false;
                }
            }
        }
        return true;
    }
}
