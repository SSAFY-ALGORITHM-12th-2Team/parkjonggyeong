

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int v, e, a, b, c, parents[];
  static ArrayList<Edge> edges;

  static void make() {
    parents = new int[v + 1];
    for (int i = 1; i <= v; i++) {
      parents[i] = i;
    }
  }

  static int findSet(int a) {
    if (parents[a] != a) {
      parents[a] = findSet(parents[a]);
    }
    return parents[a];
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

  static class Edge implements Comparable<Edge> {
    int start, end, weight;

    public Edge(int start, int end, int weight) {
      this.start = start;
      this.end = end;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(this.weight, o.weight);
    }
  }

  static public void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    v = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    edges = new ArrayList<>();


    for (int i = 1; i <= e; i++) {
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      edges.add(new Edge(a, b, c));
    }
    edges.sort(null);
    make();

    int cnt = 0;
    int cost = 0;
    for (Edge edge : edges) {
      if (union(edge.start, edge.end)) {
        cost += edge.weight;
        if (++cnt == v + 1) {
          break;
        }
      }
    }
    System.out.println(cost);
  }
}
