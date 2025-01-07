import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int farthestNode = 0;

    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight; // 간선의 가중치
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());

        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, weight));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);
        visited = new boolean[V + 1];

        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int current, int distance) {
        visited[current] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = current;
        }

        for (Node node : tree[current]) {
            if (!visited[node.to]) {
                dfs(node.to, distance + node.weight);
            }
        }
    }
}
