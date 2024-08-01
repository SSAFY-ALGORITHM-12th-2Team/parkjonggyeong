import java.util.*;
import java.io.*;

public class Main {
    static int res;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static char[][] n;
    static boolean[][] v;
    static List<int[]> selected;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                n[i][j] = input.charAt(j);
            }
        }

        res = 0;
        selected = new ArrayList<>();
        v = new boolean[5][5];
        findCombinations(0, 0, 0, 0);
        System.out.println(res);
    }

    private static void findCombinations(int x, int y, int cnt, int cntS) {
        if (cnt == 7) {
            if (cntS >= 4 && isConnected()) {
                res++;
            }
            return;
        }

        for (int i = x; i < 5; i++) {
            for (int j = (i == x ? y : 0); j < 5; j++) {
                if (v[i][j]) continue;
                selected.add(new int[]{i, j});
                v[i][j] = true;

                if (n[i][j] == 'S') {
                    findCombinations(i, j + 1, cnt + 1, cntS + 1);
                } else {
                    findCombinations(i, j + 1, cnt + 1, cntS);
                }

                v[i][j] = false;
                selected.remove(selected.size() - 1);
            }
        }
    }

    private static boolean isConnected() {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        int connectedCount = 0;

        int[] start = selected.get(0);
        queue.add(start);
        visited[start[0]][start[1]] = true;
        connectedCount++;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0], cy = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny]) {
                    for (int[] pos : selected) {
                        if (pos[0] == nx && pos[1] == ny) {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                            connectedCount++;
                            break;
                        }
                    }
                }
            }
        }

        return connectedCount == 7;
    }
}
