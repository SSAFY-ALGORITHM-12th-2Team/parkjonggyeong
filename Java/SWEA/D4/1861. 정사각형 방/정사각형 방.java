import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, result, n, map[][], cnt, room;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			room = n * n + 1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt = 0;
					dfs(i, j, 1);

					if (cnt >= result) {
					
						if (cnt == result && map[i][j] < room) {
			
							room = map[i][j];
						}
						if (cnt > result) {

							room = map[i][j];
						}
						result = cnt;
					}
				}
			}

			System.out.println("#" + t + " " + room + " " + result);
		}
	}

	private static void dfs(int x, int y, int count) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (map[nx][ny] == (map[x][y] + 1)) {
					dfs(nx, ny, (count + 1));
				}
			}
		}

		if (cnt < count) {
			cnt = count;
		}
	}
}
