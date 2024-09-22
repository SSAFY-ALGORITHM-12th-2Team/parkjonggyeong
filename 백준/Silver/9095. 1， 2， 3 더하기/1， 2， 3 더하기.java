import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, nn;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int t = 1; t <= n; t++) {
			nn = Integer.parseInt(br.readLine());
			int[] dp = new int[13];

			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int i = 4; i <= nn; i++) {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}

			System.out.println(dp[nn]);
		}
	}
}
