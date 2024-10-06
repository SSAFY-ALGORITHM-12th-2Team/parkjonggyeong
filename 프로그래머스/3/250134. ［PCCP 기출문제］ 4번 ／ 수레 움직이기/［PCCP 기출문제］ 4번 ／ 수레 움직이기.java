import java.util.*;

class Solution {
    public static int N, M, Ans = Integer.MAX_VALUE;
    public static int[][] Map;
    public static boolean[][] Red, Blue;
    public static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    public static int rx, ry, bx, by;

    public static void Dfs(int count, int x1, int y1, int x2, int y2) {
        if (Map[x1][y1] == 3 && Map[x2][y2] == 4) {
            Ans = Math.min(Ans, count);
            return;
        } else if (Map[x1][y1] == 3) {
            for (int i = 0; i < 4; i++) {
                int nx = x2 + dx[i];
                int ny = y2 + dy[i];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (Blue[nx][ny] || Map[nx][ny] == 3 || Map[nx][ny] == 5) continue;
                Blue[nx][ny] = true;
                Dfs(count + 1, x1, y1, nx, ny);
                Blue[nx][ny] = false;
            }
        } else if (Map[x2][y2] == 4) {
            for (int i = 0; i < 4; i++) {
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (Red[nx][ny] || Map[nx][ny] == 4 || Map[nx][ny] == 5) continue;
                Red[nx][ny] = true;
                Dfs(count + 1, nx, ny, x2, y2);
                Red[nx][ny] = false;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (Red[nx][ny] || Map[nx][ny] == 5) continue;

                for (int j = 0; j < 4; j++) {
                    int nnx = x2 + dx[j];
                    int nny = y2 + dy[j];
                    if (nnx < 1 || nny < 1 || nnx > N || nny > M) continue;
                    if (Blue[nnx][nny] || Map[nnx][nny] == 5) continue;
                    if (nx == nnx && ny == nny) continue; 
                    if ((nx == x2 && ny == y2) && (nnx == x1 && nny == y1)) continue;

                    Red[nx][ny] = true;
                    Blue[nnx][nny] = true;
                    Dfs(count + 1, nx, ny, nnx, nny);
                    Red[nx][ny] = false;
                    Blue[nnx][nny] = false;
                }
            }
        }
    }

    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        Map = new int[N + 1][M + 1];
        Red = new boolean[N + 1][M + 1];
        Blue = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                Map[i][j] = maze[i - 1][j - 1];
                if (Map[i][j] == 1) {
                    Red[i][j] = true;
                    rx = i;
                    ry = j;
                }
                if (Map[i][j] == 2) {
                    Blue[i][j] = true; 
                    bx = i;
                    by = j;
                }
            }
        }
        Dfs(0, rx, ry, bx, by);
        return Ans == Integer.MAX_VALUE ? 0 : Ans;
    }
}
