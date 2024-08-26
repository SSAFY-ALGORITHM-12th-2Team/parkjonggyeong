import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int r, c, cnt;
	static char[][] grid;
	static boolean[][] visited;

	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		cnt = 0;
		int size = (int) Math.pow(2, n);
		dac(size, r, c);
		System.out.println(cnt);
	}

	private static void dac(int size, int r, int c) {

		if (size == 1) {
			return;
		}
		if (r < size / 2 && c < size / 2) {
			dac(size / 2, r, c);
		} else if (r < size / 2 && c >= size / 2) {
			cnt += ((size * size) / 4);
			dac(size / 2, r, c - size / 2);
		} else if (r >= size / 2 && c < size / 2) {
			cnt += ((size * size) / 4) * 2;
			dac(size / 2, r - size / 2, c);
		} else if (r >= size / 2 && c >= size / 2) {
			cnt += ((size * size) / 4) * 3;
			dac(size / 2, r - size / 2, c - size / 2);
		}
	}
}
