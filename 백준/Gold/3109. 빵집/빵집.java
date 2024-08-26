import java.util.*;

public class Main {
	static int r, c, cnt;
	static char[][] grid;
	static boolean[][] visited;

	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		r = sc.nextInt();
		c = sc.nextInt();
		sc.nextLine();

		grid = new char[r][c];
		for (int i = 0; i < r; i++) {
			grid[i] = sc.nextLine().toCharArray();
		}

		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			if (dfs(i, 0)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static boolean dfs(int x, int y) {
		grid[x][y] = '-';

		if (y == c - 1) {
			return true;
		}

		for (int d = 0; d < 3; d++) {

			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] == '.') {
				if (dfs(nx, ny)) {
					return true;
				}

			}
		}
		return false;
	}
}
