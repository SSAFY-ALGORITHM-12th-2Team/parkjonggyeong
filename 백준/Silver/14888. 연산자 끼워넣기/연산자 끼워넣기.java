import java.io.*;
import java.util.*;

public class Main {
    static int sum, n, plus, mi, mul, div, result1, result2, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, a[], b[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        String input1[] = br.readLine().split(" ");

        a = new int[input.length];
        b = new int[input1.length];
        //숫자
        for (int i = 0; i < input.length; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        int sum = 0;

        //연산자
        for (int i = 0; i < 4; i++) {
            b[i] = Integer.parseInt(input1[i]);
            sum += b[i];
        }


        if (sum >= n) {
            return;
        }

        dfs(a[0], 1);

        bw.write(max + "\n" + min);


        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int idx) {
        if (idx == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (b[i] > 0) {
                b[i]--;

                switch (i) {
                    case 0:
                        dfs(num + a[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - a[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * a[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / a[idx], idx + 1);
                        break;
                }
                b[i] ++;

            }
        }
    }

}

