
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, n, map[][];
	static boolean check[][];
	static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			for (int d = 0; d < 100; d++) {
				check = new boolean[n][n];
				int cnt =0;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] == d) {
							map[i][j] = 0;
						}
					}
				}

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (check[i][j] == false && map[i][j] != 0) {
							bfs(i, j);
							cnt++;

						}
					}
				}
				if(result < cnt) {
					result = cnt;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		check[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (map[nx][ny] != 0 && check[nx][ny] == false) {
						check[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
		}
	}
}
