import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr = new int[101];
    static boolean[] visited = new boolean[101];
    static int[] cnt = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x] = y;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u] = v;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        cnt[1] = 0;
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                System.out.println(cnt[cur]);
                return;
            }

            for (int d = 1; d <= 6; d++) {
                int next = cur + d;
                if (next > 100) continue;
                if (visited[next]) continue;

                visited[next] = true;

                if (arr[next] != 0) {
                    if (!visited[arr[next]]) {
                        q.add(arr[next]);
                        visited[arr[next]] = true;
                        cnt[arr[next]] = cnt[cur] + 1;
                    }
                } else {
                    q.add(next);
                    cnt[next] = cnt[cur] + 1;
                }
            }
        }
    }
}
