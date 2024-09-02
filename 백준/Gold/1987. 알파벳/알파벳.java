import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, max;
    static String input;
    static int[][] al;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean v[][];
    static boolean v1[];


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        al = new int[r][c];

        for (int i = 0; i < r; i++) {
            input = br.readLine();
            for (int j = 0; j < c; j++) {
                al[i][j] = input.charAt(j) - 'A';
            }
        }

        max = 0;
        v1 = new boolean[26];
        v = new boolean[r][c];
        bfs(0, 0, 1);
        System.out.println(max);
    }

    private static void bfs(int x, int y, int cnt) {
        v1[al[x][y]] = true;
        max = Math.max(max, cnt);

        for (int d = 0; d < 4; d++) {
            int nr = x + dx[d];
            int nc = y + dy[d];
            if (nr >= 0 && nr < r && nc >= 0 && nc < c  && !v1[al[nr][nc]]) {
                v1[al[nr][nc]] = true;
                bfs(nr, nc, cnt + 1);
                v1[al[nr][nc]] = false;
            }
        }
    }
}
