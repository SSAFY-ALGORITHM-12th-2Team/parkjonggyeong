
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, n, cafe[][], startX, startY, result, max;
	static int dx[] = { 1, 1, -1, -1 }, dy[] = { 1, -1, -1, 1 };
	static boolean[][] v;
	static boolean eat[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			cafe = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}

			}

			result = -1;

			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					v = new boolean[n][n];
					eat = new boolean[101];
					startX = i;
					startY = j;
					v[i][j] = true;
					eat[cafe[i][j]] = true;
					dfs(i, j, 1, 0);
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}

	private static void dfs(int x, int y, int cnt, int go) {
	
		for (int d = go; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx == startX && ny == startY && cnt > 2) {
				result = Math.max(result, cnt);
				return;
			}
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && !eat[cafe[nx][ny]]) {
				v[nx][ny] = true;
				eat[cafe[nx][ny]] = true;
				dfs(nx, ny, cnt + 1, d);
				v[nx][ny] = false;
				eat[cafe[nx][ny]] = false;
			}
		}
	}

}
