import java.util.*;
import java.io.*;

public class Main {
    static int n, m, map[][];
    static boolean visited[][][];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m][2];
        q.offer(new int[]{0, 0, 0});  // {x, y, 벽을 부순 횟수}

        visited[0][0][0] = true;
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] idx = q.poll();
                int x = idx[0];
                int y = idx[1];
                int broken = idx[2];

                if (x == n - 1 && y == m - 1) {
                    return steps;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                            // 벽을 부수고 이동
                            visited[nx][ny][1] = true;
                            q.offer(new int[]{nx, ny, 1});
                        } else if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                            // 벽이 아닌 경우 이동
                            visited[nx][ny][broken] = true;
                            q.offer(new int[]{nx, ny, broken});
                        }
                    }
                }
            }
        }

        return -1;
    }
}
