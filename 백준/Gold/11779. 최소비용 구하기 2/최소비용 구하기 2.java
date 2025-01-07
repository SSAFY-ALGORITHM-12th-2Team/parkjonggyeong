import java.io.*;
import java.util.*;

class City implements Comparable<City> {
    int id, cost;
    City(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }
    @Override
    public int compareTo(City o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static ArrayList<City>[] graph;
    static int[] dist;
    static int[] prev;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new City(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);

        ArrayList<Integer> path = new ArrayList<>();
        for (int at = end; at != 0; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        System.out.println(path.size());
        for (int city : path) {
            System.out.print(city + " ");
        }
    }

    static void dijkstra(int start) {
        dist = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));

        while (!pq.isEmpty()) {
            City current = pq.poll();
            if (dist[current.id] < current.cost) continue;

            for (City next : graph[current.id]) {
                if (dist[next.id] > dist[current.id] + next.cost) {
                    dist[next.id] = dist[current.id] + next.cost;
                    prev[next.id] = current.id;
                    pq.offer(new City(next.id, dist[next.id]));
                }
            }
        }
    }
}
