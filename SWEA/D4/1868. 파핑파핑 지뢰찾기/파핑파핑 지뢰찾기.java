import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution {
    static int n;
    static char[][] map;
    static int[] dr = { -1, 1, 0, 0, 1, 1, -1, -1 };
    static int[] dc = { 0, 0, 1, -1, -1, 1, -1, 1 };
    static boolean[][] v;
    static int[][] arr;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];
            for (int i = 0; i < n; i++) {
                String mapx = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = mapx.charAt(j);
                }
            }
 
            v = new boolean[n][n];
            arr = new int[n][n];
            int clickCount = 0;
 
 
            for (int i = 0; i < arr.length; i++) {
                Arrays.fill(arr[i], -1);
            }
 
 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*') {
                        arr[i][j] = -1; 
                    } else {
                        int mineCount = 0;
                        for (int d = 0; d < 8; d++) {
                            int nr = i + dr[d];
                            int nc = j + dc[d];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == '*') {
                                mineCount++;
                            }
                        }
                        arr[i][j] = mineCount;  
                    }
                }
            }
 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0 && !v[i][j]) {
                        bfs(i, j);
                        clickCount++;
                    }
                }
            }
 
     
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > 0 && !v[i][j]) {
                        clickCount++;
                    }
                }
            }
 
            bw.write("#" + t + " " + clickCount + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
 
    private static void bfs(int startR, int startC) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startR, startC));
        v[startR][startC] = true;
 
        while (!q.isEmpty()) {
            Point p = q.poll();
            int r = p.x;
            int c = p.y;
 
            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
 
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !v[nr][nc]) {
                    if (arr[nr][nc] == 0) {
                        v[nr][nc] = true;
                        q.add(new Point(nr, nc));
                    } else if (arr[nr][nc] > 0) {
                        v[nr][nc] = true;
                    }
                }
            }
        }
    }
}