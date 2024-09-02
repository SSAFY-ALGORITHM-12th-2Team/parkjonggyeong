
import java.util.*;
import java.io.*;

public class Main {
	static int n, m, a, b, inDegree[];
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n + 1];

		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		inDegree = new int[n + 1];
		for (int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			inDegree[b]++;
		}
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		Queue<Integer> result = new LinkedList<>();
		while(!q.isEmpty()) {
			int p = q.poll();
			result.add(p);
			for(int i = 0; i < list[p].size(); i++) {
				int temp = list[p].get(i);
				inDegree[temp]--;
				
				if(inDegree[temp] == 0) {
					q.add(temp);
				}
			}
		}
		for(int res : result) {
			System.out.print(res + " ");
		}
		
	}
}
