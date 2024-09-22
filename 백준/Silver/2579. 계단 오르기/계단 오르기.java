import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int map[] = new int[301];
		for (int i = 1; i <= n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		int dp[] = new int[303];
		int v = 1;
		dp[1] = map[1];
		dp[2] = map[2] + map[1];
		dp[3] = Math.max(map[1], map[2]) + map[3];

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + map[i - 1], dp[i - 2]) + map[i];

		}

		System.out.println(dp[n]);
	}
}
