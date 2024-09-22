
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, days[][], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		days = new int[m + 1][2];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			days[i][0] = Integer.parseInt(st.nextToken());
			days[i][1] = Integer.parseInt(st.nextToken());
		}
		dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			int day = days[i][0];
			int maxim = days[i][1];
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i - 1][j];
				if ((j - day) >= 0) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - day] + maxim);
				}
			}
		}
		System.out.println(dp[m][n]);
	}
}
