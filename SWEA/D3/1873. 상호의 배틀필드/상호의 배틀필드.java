import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T, h, w;
        T = sc.nextInt();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int test_case = 1; test_case <= T; test_case++) {
            int x = 0;
            int y = 0;
            int d = 0;

            h = sc.nextInt();
            w = sc.nextInt();
            char[][] arr = new char[h][w];
            for (int i = 0; i < arr.length; i++) {
                String row = sc.next();
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = row.charAt(j);
                    if (arr[i][j] == '<' || arr[i][j] == '>' || arr[i][j] == '^' || arr[i][j] == 'v') {
                        if (arr[i][j] == 'v') {
                            d = 1;
                        } else if (arr[i][j] == '^') {
                            d = 0;
                        } else if (arr[i][j] == '<') {
                            d = 2;
                        } else if (arr[i][j] == '>') {
                            d = 3;
                        }
                        x = i;
                        y = j;
                    }
                }
            }

            int n = sc.nextInt();
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                char act = str.charAt(j);
                int nx, ny;

                switch (act) {
                    case 'U': {
                        d = 0;
                        nx = x + dx[d];
                        ny = y + dy[d];
                        if (0 <= nx && nx < h && 0 <= ny && ny < w && arr[nx][ny] == '.') {
                            arr[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        arr[x][y] = '^';
                        break;
                    }
                    case 'D': {
                        d = 1;
                        nx = x + dx[d];
                        ny = y + dy[d];
                        if (0 <= nx && nx < h && 0 <= ny && ny < w && arr[nx][ny] == '.') {
                            arr[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        arr[x][y] = 'v';
                        break;
                    }
                    case 'L': {
                        d = 2;
                        nx = x + dx[d];
                        ny = y + dy[d];
                        if (0 <= nx && nx < h && 0 <= ny && ny < w && arr[nx][ny] == '.') {
                            arr[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        arr[x][y] = '<';
                        break;
                    }
                    case 'R': {
                        d = 3;
                        nx = x + dx[d];
                        ny = y + dy[d];
                        if (0 <= nx && nx < h && 0 <= ny && ny < w && arr[nx][ny] == '.') {
                            arr[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                        arr[x][y] = '>';
                        break;
                    }
                    case 'S': {
                        int sx = x;
                        int sy = y;
                        while (true) {
                            sx += dx[d];
                            sy += dy[d];
                            if (sx < 0 || sx >= h || sy < 0 || sy >= w) {
                                break;
                            }
                            if (arr[sx][sy] == '*') {
                                arr[sx][sy] = '.';
                                break;
                            } else if (arr[sx][sy] == '#') {
                                break;
                            }
                        }
                        break;
                    }
                }
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }
}
