import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int g, p;
    static int result = 0;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());

        parents = new int[g+1];

        for(int i = 1; i <= g; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < p; i++) {
            int gi = Integer.parseInt(br.readLine());
            int gate = find(gi);
            if(gate == 0) {
                break;
            }

            result+=1;
            union(gate, gate - 1);
        }

        System.out.println(result);
    }

    static int find(int x) {
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parents[a] = b;
        }
    }
} 