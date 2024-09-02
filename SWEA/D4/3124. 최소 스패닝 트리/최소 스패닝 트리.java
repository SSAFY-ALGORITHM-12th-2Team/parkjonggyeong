import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int T, v, e, a, b, c, result, parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            ArrayList<Edge> edges = new ArrayList<>();
            for (int i = 0; i < e; i++) { // 간선의 수(e)를 기준으로 입력을 받습니다.
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b, c));
            }
            edges.sort(null); // 기본 정렬 기준으로 사용

            make(); // 부모 배열 초기화

            int cnt = 0;
            long cost = 0;
            for (Edge edge : edges) {
                if (union(edge.start, edge.end)) {
                    cost += edge.weight;
                    if (++cnt == v - 1) { // 모든 정점을 연결했을 때 종료
                        break;
                    }
                }
            }
            System.out.println("#" + t + " " + (cost)); // 결과 출력
        }
    }

    static void make() {
        parents = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if (parents[a] == a) {
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

    static class Edge implements Comparable<Edge> {
        int start, end;
        int weight;

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
