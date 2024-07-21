import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int map[][], n, m;
    static List<List<Integer>> g;
    static boolean ans;
    
    static int v[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String input[] = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            map = new int[m][2];
            g = new ArrayList<>();
            for(int i =0; i <= n; i ++){
                g.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                g.get(map[i][0]).add(map[i][1]);
                g.get(map[i][1]).add(map[i][0]);

            }
            ans = true;
            v = new int[n + 1];
            Arrays.fill(v, -1);
            for (int i = 1; i <= n; i++) {
                if (v[i] == -1) {
                    dfs(i, 0);
                }

            }
            if(ans == true){
                System.out.println("possible");
            }else{
                System.out.println("impossible");
            }

        }
    }

    public static void dfs(int idx, int color) {
        v[idx] = color;
        for (Integer nxt : g.get(idx)) {
            if (v[nxt] == color) {
                ans = false;
                return;
            }
            if (v[nxt] == -1) {
                dfs(nxt, (color + 1) % 2);
            }
        }
    }

}
