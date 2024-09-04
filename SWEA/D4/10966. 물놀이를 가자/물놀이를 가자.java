
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, result, n, m, wl[][], dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, 1, -1 };
	static boolean v[][];
	static Queue<Point> q;

	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			wl = new int[n][m];
			q = new LinkedList<>();
			v = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				for (int j = 0; j < m; j++) {
					wl[i][j] = input.charAt(j) - 'A';
					// *** W = 22, L = 11 ***
					
				}

			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(wl[i][j] == 22) {
						q.add(new Point(i, j, 0));
						v[i][j] = true;						
					}
				}
			}
			result = 0;
			bfs();

			System.out.println("#" + t + " " + result);
		}
	}

	private static void bfs() {

		while (!q.isEmpty()) {
			Point p = q.poll();
			result += p.cnt;
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny]) {
					v[nx][ny] = true;
					q.add(new Point(nx, ny, p.cnt + 1));
				}
			}
		}
	}
}
