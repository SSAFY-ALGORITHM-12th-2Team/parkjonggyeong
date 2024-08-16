import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static List<Integer>[] adjList;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        adjList = new ArrayList[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int neighbor = Integer.parseInt(st.nextToken());
                adjList[i].add(neighbor);
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            combination(new boolean[N + 1], 1, i);
        }

        System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference);
    }

    private static void combination(boolean[] selected, int start, int r) {
        if (r == 0) {
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (selected[i]) {
                    groupA.add(i);
                } else {
                    groupB.add(i);
                }
            }

            if (isConnected(groupA) && isConnected(groupB)) {
                int sumA = 0, sumB = 0;
                for (int i : groupA) sumA += population[i];
                for (int i : groupB) sumB += population[i];
                minDifference = Math.min(minDifference, Math.abs(sumA - sumB));
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[i] = true;
            combination(selected, i + 1, r - 1);
            selected[i] = false;
        }
    }

    private static boolean isConnected(List<Integer> group) {
        if (group.isEmpty()) return false;

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(group.get(0));
        visited[group.get(0)] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjList[current]) {
                if (!visited[neighbor] && group.contains(neighbor)) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    count++;
                }
            }
        }

        return count == group.size();
    }
}
