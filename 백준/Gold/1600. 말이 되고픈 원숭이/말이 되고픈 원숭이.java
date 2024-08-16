import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int k, w, h, map[][];
    static boolean visit[][][];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] xx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] yy = {-1, 1, 2, 2, 1, -1, -2, -2};

    static class State {
        int x, y, jump, cnt;

        public State(int x, int y, int jump, int cnt) {
            this.x = x;
            this.y = y;
            this.jump = jump;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visit = new boolean[h][w][k + 1]; 
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(x, y, 0, 0));
        visit[x][y][0] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.x == h - 1 && cur.y == w - 1) {
                return cur.cnt;
            }

            // 일반 이동
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visit[nx][ny][cur.jump] && map[nx][ny] == 0) {
                    visit[nx][ny][cur.jump] = true;
                    q.offer(new State(nx, ny, cur.jump, cur.cnt + 1));
                }
            }

            // 말처럼 점프 이동
            if (cur.jump < k) {
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + xx[d];
                    int ny = cur.y + yy[d];

                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visit[nx][ny][cur.jump + 1] && map[nx][ny] == 0) {
                        visit[nx][ny][cur.jump + 1] = true;
                        q.offer(new State(nx, ny, cur.jump + 1, cur.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }
}
