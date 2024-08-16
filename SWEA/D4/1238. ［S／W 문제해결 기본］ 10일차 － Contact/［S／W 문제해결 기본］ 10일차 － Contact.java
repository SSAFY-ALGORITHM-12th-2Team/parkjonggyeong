import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int list[][], max;
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t = 0; t < 10; t++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            list = new int[101][101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < l / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list[from][to] = 1;
            }
            bfs(s);

            System.out.println("#" + (t +1) + " " + max);
        }


    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList();
        visit = new boolean[101];
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()) {
            int cnt = q.size();
            max = 0;
            for (int i = 0; i < cnt; i++) {
                int temp = q.poll();
                max = Math.max(max, temp);
                for (int j = 1; j <= 100; j++) {
                    if (!visit[j] && list[temp][j] == 1) {
                        visit[j] = true;
                        q.offer(j);
                    }
                }
            }
        }
    }
}
