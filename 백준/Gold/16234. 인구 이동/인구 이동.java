import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, l, r, total;
    static int[][] c;
    static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static boolean[][] v;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        c = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                c[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        total = 0;
        boolean moved;

        do {
            moved = false;
            v = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j]) {
                        List<int[]> union = new ArrayList<>();
                        int sum = dfs(i, j, union);
                        if (union.size() > 1) {
                            moved = true;
                            int avg = sum / union.size();
                            for (int[] pos : union) {
                                c[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }

            if (moved) {
                total++;
            }
        } while (moved);

        System.out.println(total);
    }

    private static int dfs(int x, int y, List<int[]> union) {
        union.add(new int[]{x, y});
        v[x][y] = true;
        int sum = c[x][y];

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny]) {
                int diff = Math.abs(c[x][y] - c[nx][ny]);
                if (diff >= l && diff <= r) {
                    sum += dfs(nx, ny, union);
                }
            }
        }

        return sum;
    }
}
