import java.util.*;
import java.io.*;

public class Solution {
	static int n, m, max = Integer.MIN_VALUE;
	static List<Integer> graph[];
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			graph = new List[n + 1];
			v = new boolean[n + 1];

			for (int i = 0; i < n + 1; i++) {
				graph[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				graph[to].add(from);
			}
			for (int i = 1; i < n + 1; i++) {
				v[i] = true;
				dfs(i, 1);
				v[i] = false;
			}
			System.out.println("#" + t + " " + max);
			max = Integer.MIN_VALUE;
		}
	}

	private static void dfs(int s, int depth) {
		if (depth > max) {
			max = depth;
		}
		List<Integer> gans = graph[s];
		for (int gan : gans) {
			if (!v[gan]) {
				v[gan] = true;
				dfs(gan, depth + 1);
				v[gan] = false;
			}
		}
	}
}
