
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static int[] arr, gap;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();

	static boolean v[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		gap = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			gap[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(gap);
		arr = new int[M];
		v = new boolean[N];
		dfs(0, 0);
		System.out.println(sb);
	}

	public static void dfs(int depth, int idx) {
		Set<int[]> s = new HashSet<>();
		if (depth == M) {
				s.add(gap);
				
			for (int i = 0; i < M; i++) {
				
				sb.append(arr[i]).append(' ');
			
		}
			sb.append('\n');
			return;
		}
		int a = 0;
		for (int i = idx; i < N; i++) {

				if(a != gap[i]) {
			
					arr[depth] = gap[i];					
				a = gap[i];
				dfs(depth + 1, i);


				
			}

		}
	}

}