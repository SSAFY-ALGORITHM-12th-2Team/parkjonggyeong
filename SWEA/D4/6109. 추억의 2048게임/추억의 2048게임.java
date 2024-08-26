
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int T, n, result, map[][], arr[][];
    static String b;
    static boolean v[];
    static int[] input;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = st.nextToken();
            map = new int[n][n];
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (b.equals("up")) {
                up();
            } else if (b.equals("down")) {
                down();
            } else if (b.equals("left")) {
                left();
            } else {
                right();
            }

            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    private static void left() {
        for (int i = 0; i < n; i++) {
            int idx = 0;
            for (int j = 1; j < n; j++) {
                if (map[i][j] != 0) {
                    if (map[i][idx] == 0) {
                        map[i][idx] = map[i][j];
                        map[i][j] = 0;
                    } else if (map[i][idx] == map[i][j]) {
                        map[i][idx] *= 2;
                        map[i][j] = 0;
                        idx++;
                    } else {
                        idx++;
                        map[i][idx] = map[i][j];
                        if (idx != j) {
                            map[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    private static void right() {
        for (int i = 0; i < n; i++) {
            int idx = n - 1;
            for (int j = n - 2; j >= 0; j--) {
                if (map[i][j] != 0) {
                    if (map[i][idx] == 0) {
                        map[i][idx] = map[i][j];
                        map[i][j] = 0;
                    } else if (map[i][idx] == map[i][j]) {
                        map[i][idx] *= 2;
                        map[i][j] = 0;
                        idx--;
                    } else {
                        idx--;
                        map[i][idx] = map[i][j];
                        if (idx != j) {
                            map[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    private static void down() {
        for (int j = 0; j < n; j++) {
            int idx = n - 1;
            for (int i = n - 2; i >= 0; i--) {
                if (map[i][j] != 0) {
                    if (map[idx][j] == 0) {
                        map[idx][j] = map[i][j];
                        map[i][j] = 0;
                    } else if (map[idx][j] == map[i][j]) {
                        map[idx][j] *= 2;
                        map[i][j] = 0;
                        idx--;
                    } else {
                        idx--;
                        map[idx][j] = map[i][j];
                        if (idx != i) {
                            map[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    private static void up() {
        for (int j = 0; j < n; j++) {
            int idx = 0;
            for (int i = 1; i < n; i++) {
                if (map[i][j] != 0) {
                    if (map[idx][j] == 0) {
                        map[idx][j] = map[i][j];
                        map[i][j] = 0;
                    } else if (map[idx][j] == map[i][j]) {
                        map[idx][j] *= 2;
                        map[i][j] = 0;
                        idx++;
                    } else {
                        idx++;
                        map[idx][j] = map[i][j];
                        if (idx != i) {
                            map[i][j] = 0;
                        }
                    }
                }
            }
        }
    }
}
