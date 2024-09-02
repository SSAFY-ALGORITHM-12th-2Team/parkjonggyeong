
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
  static int n, m, parents[], u, v, k;

  private static void make() {
    parents = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parents[i] = i;
    }
  }

  private static int findSet(int a) {
    if (parents[a] != a) {
      parents[a] = findSet(parents[a]);
    }
    return parents[a];
  }

  private static boolean union(int a, int b) {
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

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    ArrayList<Edge> edges = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      edges.add(new Edge(u, v, i + 1));
    }


    for (int l = 0; l < k; l++) {
      edges.sort(null);
      make();
      int cnt = 0;
      int cost = 0;
      int result = 0;
      for (Edge edge : edges) {
        if (union(edge.start, edge.end)) {
          cost += edge.weight;
          result++;
          if (++cnt == n  - 1) {
            break;
          }
        }

      }
      if(result == n - 1){
        System.out.print(cost + " ");
      }else{
        System.out.print(0 + " ");
      }

      edges.remove(0);
    }

  }
}