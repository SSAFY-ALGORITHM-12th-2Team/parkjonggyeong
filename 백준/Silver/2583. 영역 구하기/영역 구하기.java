import java.io.*;
import java.util.*;

public class Main {
	static int M, N, K, x, y, xx, yy, map[][], temp;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		for (int c = 0; c < K; c++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			xx = Integer.parseInt(st.nextToken());
			yy = Integer.parseInt(st.nextToken());
			for (int i = y; i < yy; i++) {
				for (int j = x; j < xx; j++) {
					map[i][j] = -1;
				}
			}
		}

		List<Integer> lists = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != -1) {
					bfs(i, j);
					lists.add(temp);
				}
			}
		}

		Collections.sort(lists);

		System.out.println(lists.size());
		for (int i = 0; i < lists.size(); i++) {
			System.out.print(lists.get(i) + " ");
		}
	}

	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));
		temp = 0;
		map[r][c] = -1;

		while (!q.isEmpty()) {
			temp++;
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
					if (map[nr][nc] != -1) {
						q.add(new Point(nr, nc));
						map[nr][nc] = -1;
					}
				}
			}
		}
	}
}
