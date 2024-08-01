
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static long n, b, c, sum, cnt;
	static long[] a1;
	static String input[], a[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		n = Integer.parseInt(br.readLine());
		a = br.readLine().split(" ");
		a1 = new long[a.length];
		for (int i = 0; i < n; i++) {
			a1[i] = Integer.parseInt(a[i]);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sum = 0;
		cnt = 0;

		for (int i = 0; i < a1.length; i++) {
			a1[i] = a1[i] - b;
			cnt++;
			if (a1[i] % c < c && a1[i] > 0) {
				cnt += a1[i] / c;
				a1[i] = a1[i] % c;
				if (a1[i] % c != 0) {
					a1[i] = 0;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
