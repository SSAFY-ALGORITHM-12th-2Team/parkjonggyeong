import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.*;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;


public class Main {
    static int[][] map;
    static int cnt, n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());// 0, 1, 2, 3, 북, 동, 남, 서

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 1;

        dfs(r, c, d);
        System.out.println(cnt);
    }

    private static void dfs(int r, int c, int d) {

        map[r][c] = -1;
        //반시계방향으로 돌기 위해
        for (int q = 0; q < 4; q++) {
            d = (d + 3) % 4;
            int nx = r + dx[d];
            int ny = c + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                cnt++;
                dfs(nx, ny, d);
                //찾았으니 멈춰
                return;
            }
        }
        // 다돌았는데 없으니 후진
        int back = (d + 2) % 4;
        int xx = r + dx[back];
        int xy = c + dy[back];
        if (xx >= 0 && xx < n && xy < m && xy >= 0 && map[xx][xy] != 1) {
            dfs(xx, xy, d);
        }
    }
}
