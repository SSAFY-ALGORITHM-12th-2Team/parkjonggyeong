import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, to, from;
    static ArrayList<Integer>[] adj;
    static boolean v[];
    static boolean found; // 길이 5의 경로를 찾았는지 여부

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }

        v = new boolean[n];
        found = false;

        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (found) break; // 찾았다면 더 이상 탐색하지 않음
        }

        System.out.println(found ? 1 : 0);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == 5) {
            found = true;
            return;
        }
        v[idx] = true;
        for (int nxt : adj[idx]) {
            if (!v[nxt]) { // 다음 노드가 방문되지 않은 경우만 탐색
                dfs(nxt, cnt + 1);
                if (found) return; // 찾으면 즉시 종료
            }
        }
        v[idx] = false; // 백트래킹
    }
}
