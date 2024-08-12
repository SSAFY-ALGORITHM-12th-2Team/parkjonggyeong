
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n, k, map[][], result, max;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };
	static boolean[][] v;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			
			result = -1;
			max = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			v = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(max, map[i][j]);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == max) {

						v[i][j] = true;
						dfs(i, j, 1, max, k);
						v[i][j] = false;

					}
				}
			}

			System.out.println("#"+t+" "+result);
		}
	}

	private static void dfs(int x, int y, int length, int max, int k) {

		result = Math.max(length, result);

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && v[nx][ny] == false) {
			
					if (max > map[nx][ny]) {

						v[nx][ny] = true;
						dfs(nx, ny, length + 1, map[nx][ny], k);
						v[nx][ny] = false;

					} else if (max > (map[nx][ny] - k)) {

						v[nx][ny] = true;
						dfs(nx, ny, length + 1, max - 1, 0);
						v[nx][ny] = false;
					}
				
			}

		}

	}
}
