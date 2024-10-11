
import java.util.*;
import java.awt.Point;
import java.io.*;

public class Solution {
	static int n, result, x;
	static int omap[][], remap[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			result = 0;
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			omap = new int[n][n];
			remap = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					omap[i][j] = Integer.parseInt(st.nextToken());
					remap[j][i] = omap[i][j];
				}
			}
			solution(omap);
			solution(remap);

			System.out.println("#" + t + " " + result);
		}
	}

	private static void solution(int[][] map) {
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			int level = 1;
			for (int j = 1; j < n; j++) {
				if (map[i][j - 1] != map[i][j]) {
					if (map[i][j - 1] == map[i][j] + 1) {
						level = 0;
						if (check(map, i, j, map[i][j])) {
							j += x - 1;
						} else {
							flag = false;
							break;
						}
					} else if (map[i][j - 1] == map[i][j] - 1) {
						if (level < x) {
							flag = false;
							level = 1;
							break;
						}
						level = 1;
					} else {
						flag = false;
						level = 1;
						break;
					}
				} else {
					level++;
				}
				
			}
			if (flag == true) {
				result++;
			}
		}
	}

	private static boolean check(int[][] map, int i, int j, int height) {
		int h = 1;
		while (h < x && j + h < n && map[i][j + h] == height) {
			h++;
		}
		if (h == x) {
			return true;
		}
		return false;
	}
}
