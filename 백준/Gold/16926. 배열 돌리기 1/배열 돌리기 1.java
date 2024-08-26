

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, r, map[][];
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		int rotate = (Math.min(n, m) / 2);

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < r; k++) {
			for (int i = 0; i < rotate; i++) {
				int now = map[i][i];
				int r = i, c = i;
				int d = 0;
				
				while (d < 4) {
					
					int x = r + dx[d];
					int y = c + dy[d];
					
					if (x >= i && y >= i && x < n - i && y < m - i) {
						map[r][c] = map[x][y];
						r = x;
						c = y;
						
					} else {
						d++;
					}
				}
				map[i + 1][i] = now;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}