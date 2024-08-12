import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, m, n, k, x, y, cnt;
    static boolean visit[][];

    static int[][] car;

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            cnt = 0;
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            car = new int[m][n];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                car[p1][p2] = 1;
            }

            visit = new boolean[m][n];


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (car[i][j] == 1 && visit[i][j] == false) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && visit[nx][ny] == false && car[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
