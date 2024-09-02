import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, n, k, x, y, inDegree[], d[], w;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            d = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            inDegree = new int[n + 1];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                inDegree[y]++;
            }
            w = Integer.parseInt(br.readLine());
            bfs();
        }

    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int result[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = d[i];
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int p = q.poll();

            for (int i = 0; i < list[p].size(); i++) {
                int temp = list[p].get(i);
                result[temp] = Math.max(result[temp], result[p] + d[temp]);
                inDegree[temp]--;
                if (inDegree[temp] == 0) {
                    q.add(temp);
                }
            }
        }
        System.out.println(result[w]);
    }
}
