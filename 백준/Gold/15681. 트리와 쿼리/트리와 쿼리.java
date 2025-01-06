import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] v;
    static int[] subtree;
    static int[] u;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        subtree = new int[n + 1];
        v = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        u = new int[q];

        for (int i = 0; i < q; i++) {
            u[i] = Integer.parseInt(br.readLine());
        }

        dfs(r);

        for (int i = 0; i < u.length; i++) {
            System.out.println(subtree[u[i]]);
        }
    }

    private static void dfs(int node) {
        v[node] = true;
        subtree[node] = 1;

        for (int sub : tree[node]) {
            if (!v[sub]) {
                dfs(sub);
                subtree[node] += subtree[sub];
            }
        }
    }
}
