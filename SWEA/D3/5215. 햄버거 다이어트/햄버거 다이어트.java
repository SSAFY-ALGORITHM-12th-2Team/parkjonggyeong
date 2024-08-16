import java.util.*;

import java.io.*;

//조합, 멱집합 풀기(햄버거 다이어트)
public class Solution {
	static int result;
	static int T;
	static int[][] map;
	static int n, l, a[], b[];
	static boolean[] sel;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] line = br.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			l = Integer.parseInt(line[1]);

			map = new int[n][2];
			for (int i = 0; i < n; i++) {
				line = br.readLine().split(" ");
				map[i][0] = Integer.parseInt(line[0]);
				map[i][1] = Integer.parseInt(line[1]);
			}
			max = Integer.MIN_VALUE;
			sel = new boolean[map.length];
			r(0, 0, 0);

			System.out.println("#" + t + " " + max);
		}
	}

	private static void r(int idx, int k, int re) {
		if (k > l) {
			return;
		}
		if (idx == n) {
			for (int i = 0; i < sel.length; i++) {
				if (sel[i] = true) {
					if (k <= l) {
						max = Math.max(max, re);
					}
				}
			}
			return;
		}
		
		sel[idx] = true;
		r(idx + 1, k + map[idx][1], re + map[idx][0]);
		// x
		sel[idx] = false;
		r(idx + 1, k, re);

	}

}
