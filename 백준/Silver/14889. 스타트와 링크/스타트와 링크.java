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
	static boolean go[];
	static int n, max = Integer.MAX_VALUE, result, map[][], a, b, minus;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		go = new boolean[n];
		dfs(0, 0);

		System.out.println(max);
	}

	private static void dfs(int start, int d) {
		if (d == n / 2) {
			minus = 0;
			a = 0;
			b = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (go[i] == false && go[j] == false) {
						a += (map[i][j] + map[j][i]);
						//System.out.println(map[i][j] + "map[i][j]");
						//System.out.println(map[j][i] + "map[j][i]");
					} else if (go[i] == true && go[j] == true) {
						b += (map[i][j] + map[j][i]);

					}

				}
			
				
				//System.out.println(a + "a");
				//System.out.println(b + "b");
				//System.out.println(result);
				
			}
			
			minus = Math.abs(a - b);
			if(minus == 0) {
				max = minus;
				return;
			}
			max = Math.min(minus, max);

			return;

		}

		for (int i = start; i < n; i++) {
			if (go[i] == false) {
				go[i] = true;
				dfs(i + 1, d + 1);
				go[i] = false;

			}

		}
	}
}