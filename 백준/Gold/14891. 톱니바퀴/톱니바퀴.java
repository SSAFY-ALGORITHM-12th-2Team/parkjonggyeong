
import java.util.*;
import java.io.*;

public class Main {
    static int k, num, dir;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};

    static int[][] wheel;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wheel = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = s.charAt(j) - '0';
            }
        }
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken()) - 1;
            dir = Integer.parseInt(st.nextToken());

            // 오른쪽 회전
            int w = wheel[num][2];
            int curDir = dir;
            for (int j = num + 1; j < 4; j++) {
                if (wheel[j][6] != w) {
                    w = wheel[j][2];
                    curDir *= -1;
                    rotate(j, curDir);
                } else {
                    break;
                }
            }
            // 왼족 회전
            w = wheel[num][6];
            curDir = dir;
            for (int j = num - 1; j >= 0; j--) {
                if (wheel[j][2] != w) {
                    w = wheel[j][6];
                    curDir *= -1;
                    rotate(j, curDir);
                } else {
                    break;
                }
            }
            rotate(num, dir);
        }
        int cnt = 0;
        if (wheel[0][0] == 1) {
            cnt += 1;
        }
        if (wheel[1][0] == 1) {
            cnt += 2;
        }
        if (wheel[2][0] == 1) {
            cnt += 4;
        }
        if (wheel[3][0] == 1) {
            cnt += 8;

        }
        System.out.println(cnt);
        br.close();
    }

    private static void rotate(int j, int dir) {

        if (dir == -1) {
            int first = wheel[j][0];
            for (int i = 0; i < 7; i++) {
                wheel[j][i] = wheel[j][i + 1];
            }
            wheel[j][7] = first;
        } else {
            int last = wheel[j][7];
            for (int i = 7; i > 0; i--) {
                wheel[j][i] = wheel[j][i - 1];
            }
            wheel[j][0] = last;
        }
    }
}
