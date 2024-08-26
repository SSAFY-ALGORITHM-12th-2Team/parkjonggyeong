import java.util.*;

import java.io.*;

public class Main {

	static char[][] map;
	static int bomb[][], time, r, c, n;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < n - i -1; j++) {
				System.out.print(" ");
			}
			
			for (int j = n; j >= n - i; j--) {
				System.out.print("*");

			}
			for (int j = n - 1; j >= n - i; j--) {
				System.out.print("*");

			}

			System.out.println();

		}
	}
}
