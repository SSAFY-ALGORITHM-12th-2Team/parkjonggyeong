import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static List<Point> emptySpaces;
    static List<Point> virusList;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int maxSafeArea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        emptySpaces = new ArrayList<>();
        virusList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptySpaces.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        maxSafeArea = 0;
        // 모든 빈 공간 중 3개의 벽을 세우는 조합을 시도
        combination(0, 0);
        System.out.println(maxSafeArea);
    }

    // 빈 공간 중 3개를 선택하여 벽을 세우는 조합을 생성
    static void combination(int start, int count) {
        if (count == 3) {
            simulateVirusSpread();
            return;
        }

        for (int i = start; i < emptySpaces.size(); i++) {
            Point p = emptySpaces.get(i);
            map[p.x][p.y] = 1; // 벽 세우기
            combination(i + 1, count + 1);
            map[p.x][p.y] = 0; // 벽 제거 (백트래킹)
        }
    }

    static void simulateVirusSpread() {
        int[][] tempMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, m);
        }

        Queue<Point> queue = new LinkedList<>(virusList);
        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        // 안전 영역 크기 계산
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
}
