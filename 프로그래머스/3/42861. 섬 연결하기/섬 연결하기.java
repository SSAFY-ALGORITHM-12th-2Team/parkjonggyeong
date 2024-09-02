import java.util.*;

class Solution {

    static int parents[];

    public int solution(int n, int[][] costs) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            edges.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));      
        }
        edges.sort(null);
        make(n);
        
        int cnt = 0;
        int cost = 0;
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                cost += edge.weight;
                if (++cnt == n - 1) {
                    break;
                }
            }
        }
        return cost;
    }

    public void make(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int findSet(int a) {
        if (parents[a] != a) {
            parents[a] = findSet(parents[a]); 
        }
        return parents[a];
    }

    public boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) {
            return false;
        }
        parents[bRoot] = aRoot;
        return true;
    }       

    class Edge implements Comparable<Edge> {
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
}
