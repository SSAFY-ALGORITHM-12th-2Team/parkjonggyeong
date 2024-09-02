import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, n, xx[], yy[];
	static int[] parents;
	static double e;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			xx = new int[n];
			yy = new int[n];
			for (int i = 0; i < n; i++) {
				xx[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				yy[i] = Integer.parseInt(st.nextToken());
			}
			e = Double.parseDouble(br.readLine());

			List<Point> list = new LinkedList<Point>();
			for (int i = 0; i < n; i++) {
				list.add(new Point(xx[i], yy[i]));
			}

			ArrayList<Edge> edges = new ArrayList<Edge>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					long distX = Math.abs(xx[i] - xx[j]);
					long distY = Math.abs(yy[i] - yy[j]);
					edges.add(new Edge(i, j, (distX * distX + distY * distY)));
				}
			}
			edges.sort(null);
			make();
			
			int cnt = 0;
					long cost = 0;
			for (Edge edge : edges) {
				if (union(edge.start, edge.end)) {
					cost += edge.weight;
					if (++cnt == n - 1) {
						break;
					}
				}
			}
			System.out.println("#" + t + " " + (long) Math.round(cost * e));

		}
	}

	static void make() {
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] =  -1;
		}
	}

	static int findSet(int a) {
		if (parents[a] < 0) {
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

		parents[aRoot] += parents[bRoot];
		parents[bRoot] = aRoot;
		return true;
	}

	static class Edge implements Comparable<Edge> {
		int start, end;
		long weight;

		public Edge(int start, int end, long weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}
}
