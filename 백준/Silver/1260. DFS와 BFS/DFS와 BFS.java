import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, v, a, b, arr[][];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input[] = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            a = Integer.parseInt(str.nextToken());
            b = Integer.parseInt(str.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        visit = new boolean[n + 1];
        dfs(v);
        System.out.println();
        visit = new boolean[n + 1];
        bfs(v);
        System.out.println();
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visit[v] = true;

        System.out.print(v + " ");

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < arr.length; i++) {
                if (arr[temp][i] == 1 && visit[i] == false) {
                    q.add(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    private static void dfs(int v) {
        visit[v] = true;
        System.out.print(v + " ");

        if (v == arr.length) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[v][i] == 1 && visit[i] == false) {
                dfs(i);
            }
        }
    }
}
