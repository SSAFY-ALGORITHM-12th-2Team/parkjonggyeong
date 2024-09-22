import java.util.*;

import java.io.*;

public class Main {

	static char[][] map;
	static int bomb[][], time, t[], p[], n;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		// 왼쪽
		String[] input = new String[2];
		t = new int[n];
		p = new int[n];
		int dp[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < 2; j++) {
				t[i] = Integer.parseInt(input[0]);
				p[i] = Integer.parseInt(input[1]);
			}
		}
		for (int i = 0; i < n; i++) {
			if (i + t[i] <= n) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
			dp[i + 1] = Math.max(dp[i], dp[i + 1]);
		}

		System.out.println(dp[n]);
	}

}