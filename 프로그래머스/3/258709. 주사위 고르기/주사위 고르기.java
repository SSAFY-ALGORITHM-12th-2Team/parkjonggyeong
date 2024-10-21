import java.util.*;

class Solution {
    static int x, y, z;
    static int[][] arr;

    public int[] solution(int[][] dice) {
        x = dice.length;
        arr = dice;
        y = 0;
        z = 0;
        a(0, 0);

        int[] res = new int[x / 2];
        int idx = 0;
        for (int i = 0; i < x; i++) {
            if ((z & (1 << i)) > 0) {
                res[idx++] = i + 1;
            }
        }

        return res;
    }

    private static void a(int idx, int s) {
        if (idx == x) {
            if (Integer.bitCount(s) == x / 2) {
                b(s);
            }
            return;
        }

        a(idx + 1, s);
        a(idx + 1, s + (1 << idx));
    }

    static Map<Integer, Integer> m1;
    static Map<Integer, Integer> m2;
    private static void b(int s) {
        m1 = new HashMap<>();
        m2 = new HashMap<>();
        c(0, s, new int[x / 2]);

        int win = 0;
        for (Map.Entry<Integer, Integer> e1 : m1.entrySet()) {
            int k1 = e1.getKey();
            int v1 = e1.getValue();
            for (Map.Entry<Integer, Integer> e2 : m2.entrySet()) {
                int k2 = e2.getKey();
                int v2 = e2.getValue();
                if (k1 > k2) {
                    win += v1 * v2;
                }
            }
        }

        if (y < win) {
            y = win;
            z = s;
        }
    }

    private static void c(int idx, int s, int[] d) {
        if (idx == x / 2) {
            int[] t1 = new int[x / 2];
            int[] t2 = new int[x / 2];
            int i1 = 0, i2 = 0;
            for (int i = 0; i < x; i++) {
                if ((s & (1 << i)) > 0) {
                    t1[i1++] = i;
                } else {
                    t2[i2++] = i;
                }
            }

            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < x / 2; i++) {
                int num = d[i];
                sum1 += arr[t1[i]][num];
                sum2 += arr[t2[i]][num];
            }

            m1.put(sum1, m1.getOrDefault(sum1, 0) + 1);
            m2.put(sum2, m2.getOrDefault(sum2, 0) + 1);

            return;
        }

        for (int i = 0; i < 6; i++) {
            d[idx] = i;
            c(idx + 1, s, d);
        }
    }
}
