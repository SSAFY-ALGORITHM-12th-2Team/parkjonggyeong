
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int T, n, m, person[][], parents[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			person = new int[m][2];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				person[i][0] = Integer.parseInt(st.nextToken());
				person[i][1] = Integer.parseInt(st.nextToken());
			}

			parents = new int[n + 1];
			make();
			for (int i = 0; i < m ; i++) {
				union(person[i][0], person[i][1]);
			}
			
			int cnt = 0;
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i <= n; i++) {
				if(parents[i] == i) {
			
					cnt++;
					
				}
			}
			

			
			System.out.println("#" + t + " " + cnt);
		}
	}

	static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {

		if (a == parents[a]) {
			return a;
		}

		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
}
