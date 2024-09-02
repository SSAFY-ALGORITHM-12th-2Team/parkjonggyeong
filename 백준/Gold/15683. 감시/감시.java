import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class CCTV {
        int x, y, type;

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    static int n, m, max = Integer.MAX_VALUE;
    static int[][] map;
    static List<CCTV> cctvList = new ArrayList<>();
    static int[] dx = { 0, -1, 0, 1 }; // 우, 상, 좌, 하
    static int[] dy = { 1, 0, -1, 0 };
    static int[][][] directions = {
        {}, // 빈 공간
        {{0}, {1}, {2}, {3}}, // 1번 CCTV
        {{0, 2}, {1, 3}}, // 2번 CCTV
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 CCTV
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번 CCTV
        {{0, 1, 2, 3}} // 5번 CCTV
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        backtrack(0, map);
        System.out.println(max);
    }

    private static void backtrack(int index, int[][] mapCopy) {
        if (index == cctvList.size()) {
            max = Math.min(max, countBlindSpots(mapCopy));
            return;
        }

        CCTV cctv = cctvList.get(index);
        int type = cctv.type;

        for (int[] direction : directions[type]) {
            int[][] tempMap = deepCopyMap(mapCopy);
            for (int d : direction) {
                monitor(tempMap, cctv.x, cctv.y, d);
            }
            backtrack(index + 1, tempMap);
        }
    }

    private static void monitor(int[][] mapCopy, int x, int y, int dir) {
        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (x < 0 || y < 0 || x >= n || y >= m || mapCopy[x][y] == 6) break;
            if (mapCopy[x][y] == 0) {
                mapCopy[x][y] = -1;
            }
        }
    }

    private static int countBlindSpots(int[][] mapCopy) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mapCopy[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[][] deepCopyMap(int[][] original) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, m);
        }
        return copy;
    }
}
