import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new ArrayList<>();
        list = new ArrayList[n + 1];
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            arr[b]++;
        }
        topol();
        for (int ans : result) {
            System.out.print(ans + " ");
        }

    }

    private static void topol() {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int p = q.poll();
            result.add(p);
            for (int next : list[p]){
                arr[next]--;
                if (arr[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
