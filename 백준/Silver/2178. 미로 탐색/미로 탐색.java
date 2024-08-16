import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    static int n, m, map[][];
    static boolean visited[][];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    private static int bfs(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visited[i][j] = true;

        int count = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                Point a = q.poll();

                if (a.x == n - 1 && a.y == m - 1) {
                    return count;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = a.x + dx[d];
                    int ny = a.y + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == 1 && !visited[nx][ny]) {
                            q.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
