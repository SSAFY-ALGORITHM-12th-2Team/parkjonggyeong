import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        per(n, m, new boolean[n], 0);

    }

    private static void per(int n, int m, boolean[] v, int depth) {
        if (depth == m) {
            for(int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!v[i]){
                v[i] = true;
                arr[depth] = i + 1;
                per(n, m, v, depth + 1);
                v[i] = false;    
            }
            
        }
    }
}