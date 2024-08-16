

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map[][], sum, res, dis[][], cnt;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = 1;
		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			StringTokenizer st;
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			dis = new int[n][n];
			res = Integer.MAX_VALUE;
			bfs(0, 0, new boolean[n][n], n);
			
			System.out.println("Problem " + cnt + ": " + (dis[n - 1][n - 1] + map[n - 1][n - 1]));
			cnt = cnt + 1;
		}
	}

	private static void bfs(int x, int y, boolean[][] v, int n) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dis[i][j] = Integer.MAX_VALUE;
			}
		}
		while (!q.isEmpty()) {
			Node s = q.poll();
			// System.out.println(map[s.x][s.y]);

			if (dis[s.x][s.y] < s.cost) {
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int nx = s.x + dx[d];
				int ny = s.y + dy[d];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (map[s.x][s.y] + s.cost < dis[nx][ny]) {
						dis[nx][ny] = map[s.x][s.y] + s.cost;
						q.offer(new Node(nx, ny, dis[nx][ny]));
					}
				}
			}
		}
	}

	static class Node {
		int x;
		int y;
		int cost;

		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
