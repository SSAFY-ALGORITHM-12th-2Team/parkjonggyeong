import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	static int T, m, result, num[], renum;
	static String n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = st.nextToken();
			m = Integer.parseInt(st.nextToken());

			num = new int[n.length()];

			for (int i = 0; i < num.length; i++) {
				num[i] = n.charAt(i) - '0';
			}
			result = 0;

			if (num.length < m) {
				m = num.length;
			}

			dfs(0, 0);
			// System.out.println(renum);
			System.out.println("#" + t + " " + result);
		}

	}

	private static void dfs(int start, int depth) {
		if (depth == m) {
			renum = 0;
			for (int i = 0; i < num.length; i++) {
				renum += Math.pow(10, i) * num[num.length - i - 1];
				// System.out.println(num[i]);
			}

			result = Math.max(result, renum);
			return;
		}

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				swap(i, j);
				dfs(i, depth + 1);
				swap(i, j);
			}
		}
	}

	private static void swap(int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
