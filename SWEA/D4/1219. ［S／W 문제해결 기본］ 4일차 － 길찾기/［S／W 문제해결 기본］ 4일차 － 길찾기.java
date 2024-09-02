
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int T, n, arr[][], result;
    static boolean v[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        for (int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine());
            int testCase = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

  
            arr = new int[n][2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            result = 0;
            v = new boolean[n];
            bfs(0, 0);
            System.out.println("#" + testCase + " " + result);
        }
    }

    private static void bfs(int start, int end) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start, end));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.y == 99) {
                result = 1;
                break;
            }

            for (int i = 0; i < n; i++) {
                if (p.y == arr[i][0] && !v[i]) {
                    v[i] = true; // Mark this point as visited
                    q.add(new Point(arr[i][0], arr[i][1]));
                }
            }
        }
    }
}
