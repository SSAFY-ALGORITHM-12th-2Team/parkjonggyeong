import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
	static int T, n, b, result;
	static boolean v[];
	static int[] input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			input = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			result = Integer.MAX_VALUE;
			v = new boolean[n];
			Arrays.sort(input);
			run(0, 0);
			System.out.println("#" + t + " " + result);
		}
	}

	private static void run(int cnt, int sum) {
		if (cnt + 1 > n) {
			if (b <= sum) {
				result = Math.min(result, sum - b);
				// System.out.println(result);
			}
			return;
		}

		run(cnt + 1, input[cnt] + sum);
		run(cnt + 1, sum);

	}
}