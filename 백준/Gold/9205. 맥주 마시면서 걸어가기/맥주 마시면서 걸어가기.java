import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Point[] locations = new Point[n + 2];

            st = new StringTokenizer(br.readLine());
            locations[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                locations[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            locations[n + 1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            // BFS to find if we can reach the festival
            boolean result = canReachFestival(locations, n);
            System.out.println(result ? "happy" : "sad");
        }
    }

    private static boolean canReachFestival(Point[] locations, int n) {
        boolean[] visited = new boolean[n + 2];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(locations[0]);  // Start from home
        visited[0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < n + 2; i++) {
                if (!visited[i] && canReach(current, locations[i])) {
                    if (i == n + 1) { // If it's the festival
                        return true;
                    }
                    visited[i] = true;
                    queue.offer(locations[i]);
                }
            }
        }
        return false;
    }

    private static boolean canReach(Point p1, Point p2) {
        int distance = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        return distance <= 1000; // Can reach if distance is within 1000 meters
    }
}
