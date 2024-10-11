
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Point {
        int x, y, power;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int power) {
            this.x = x;
            this.y = y;
            this.power = power;
        }
    }

    static int T, W, H, N;
    static int[][] map;
    static int[][] copy;
    static Point[] dir = { new Point(0, 1), new Point(0, -1), new Point(1, 0), new Point(-1, 0) };
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            copy = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = map[i][j];
                }
            }
            min = Integer.MAX_VALUE;
            dfs(0, new int[N]);
            System.out.printf("#%d %d\n", t, min);
        }
    }

    static void dfs(int depth, int[] selected) {
        if (depth == N) {
            start(selected);
            min = Math.min(countMap(), min);
            copyMap();
            return;
        }

        for (int w = 0; w < W; w++) {
            selected[depth] = w;
            dfs(depth + 1, selected);
        }
    }

    static void start(int[] arr) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < H; j++) {
                if (map[j][arr[i]] != 0) {
                    x = j;
                    y = arr[i];
                    break;
                }
            }
            bfs(x, y);
            blockdown();
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(x, y, map[x][y]));
        map[x][y] = 0;

        while (!que.isEmpty()) {
            Point curr = que.poll();
            int power = curr.power;
            for (int i = 1; i < power; i++) {
                for (Point d : dir) {
                    int nx = curr.x + d.x * i;
                    int ny = curr.y + d.y * i;

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (map[nx][ny] == 0) continue;

                    que.add(new Point(nx, ny, map[nx][ny]));
                    map[nx][ny] = 0;
                }
            }
        }
    }

    static void blockdown() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (map[j][i] != 0) stack.add(map[j][i]);
            }
            for (int j = H - 1; j >= 0; j--) {
                if (stack.isEmpty()) map[j][i] = 0;
                else map[j][i] = stack.pop();
            }
        }
    }

    static int countMap() {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] != 0) count++;
            }
        }
        return count;
    }

    static void copyMap() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = copy[i][j];
            }
        }
    }
}
