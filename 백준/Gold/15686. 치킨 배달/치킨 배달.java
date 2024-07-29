import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

public class Main {
	static ArrayList<Point> home;
	static ArrayList<Point> chicken;
	static boolean go[];
	static int m, n, max = Integer.MAX_VALUE, result, map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String input[] = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n][n];
		home = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					home.add(new Point(i, j));
				}
				if (map[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}

		go = new boolean[chicken.size()];
		dfs(0, 0);

		System.out.println(max);
	}

	private static void dfs(int start, int d) {
		if (d == m) {
			result = 0;

			for (int i = 0; i < home.size(); i++) {
				int res = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					//System.out.println(go[j]);
					if (go[j] == true) {
						// |x - x| + |y- y|
						int dis = (Math.abs(home.get(i).getX() - chicken.get(j).getX())
								+ Math.abs(home.get(i).getY() - chicken.get(j).getY()));
						res = Math.min(res, dis);
					}
				}
				result += res;
			}

			max = Math.min(max, result);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			if (go[i] == false) {
				go[i] = true;
				dfs(i + 1, d + 1);
				go[i] = false;

			}
		}
	}
}