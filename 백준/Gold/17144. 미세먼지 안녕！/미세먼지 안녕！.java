import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int r, c, t;
    static int[][] air;
    static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
    static int top = -1, bot = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        air = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                air[i][j] = Integer.parseInt(st.nextToken());
                if (air[i][j] == -1) {
                    if (top == -1) {
                        top = i;
                    } else {
                        bot = i;
                    }
                }
            }
        }
        for (int i = 0; i < t; i++) {
            dif();
            clean();
        }
        int total = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                total += air[i][j];
            }
        }
        System.out.println(total + 2);
    }

    private static void dif() {
        int[][] newair = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (air[i][j] > 0) {
                    int spread = air[i][j] / 5;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && nx < r && ny >= 0 && ny < c && air[nx][ny] != -1) {
                            newair[nx][ny] += spread;
                            air[i][j] -= spread;
                        }
                    }
                }
                newair[i][j] += air[i][j];
            }
        }
        air = newair;
    }

    private static void clean() {
        // 위 회전
        for (int i = top - 1; i > 0; i--) {
            air[i][0] = air[i - 1][0];
        }
        for (int j = 0; j < c - 1; j++) {
            air[0][j] = air[0][j + 1];
        }
        for (int i = 0; i < top; i++) {
            air[i][c - 1] = air[i + 1][c - 1];
        }
        for (int j = c - 1; j > 1; j--) {
            air[top][j] = air[top][j - 1];
        }
        air[top][1] = 0;
        // 아래 회전
        for (int i = bot + 1; i < r - 1; i++) {
            air[i][0] = air[i + 1][0];
        }
        for (int j = 0; j < c - 1; j++) {
            air[r - 1][j] = air[r - 1][j + 1];
        }
        for (int i = r - 1; i > bot; i--) {
            air[i][c - 1] = air[i - 1][c - 1];
        }
        for (int j = c - 1; j > 1; j--) {
            air[bot][j] = air[bot][j - 1];
        }
        air[bot][1] = 0;
    }

}
