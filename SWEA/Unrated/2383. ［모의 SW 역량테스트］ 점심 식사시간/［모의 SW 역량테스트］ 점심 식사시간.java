import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Stair {
        int r;
        int c;
        int gap;

        public Stair(int r, int c, int gap) {
            this.r = r;
            this.c = c;
            this.gap = gap;
        }
    }

    static class Point {
        int x;
        int y;
        int dist; // The index of the stair to go to (0 or 1)
        int time; // Time when the person can start going down
        int finish; // Time when the person finishes going down

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int T, n, build[][], result, res;
    static boolean[] v;
    static List<Point> person;
    static Queue<Point>[] down;
    static Stair[] stair;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            down = new LinkedList[2];
            person = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            build = new int[n][n];
            stair = new Stair[2];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    build[i][j] = Integer.parseInt(st.nextToken());
                    if (build[i][j] == 1) {
                        person.add(new Point(i, j));
                    } else if (build[i][j] > 1) {
                        stair[idx++] = new Stair(i, j, build[i][j]);
                    }
                }
            }

            result = Integer.MAX_VALUE;
            powerSet(0);
            System.out.println("#" + t + " " + result);
        }
    }

    private static void powerSet(int cnt) {
        if (cnt == person.size()) {
            v = new boolean[person.size()];
            down[0] = new LinkedList<>();
            down[1] = new LinkedList<>();
            calculate();
            result = Math.min(result, res);
            return;
        }

        person.get(cnt).dist = 0;
        person.get(cnt).time = calculateTime(person.get(cnt), 0);
        powerSet(cnt + 1);

        person.get(cnt).dist = 1;
        person.get(cnt).time = calculateTime(person.get(cnt), 1);
        powerSet(cnt + 1);
    }

    private static void calculate() {
        int time = 1;
        int count = 0;
        res = 0;

        while (true) {
            for (Queue<Point> q : down) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Point p = q.poll();
                    Stair st = stair[p.dist];
                    if (p.finish <= time) {
                        continue;
                    }
                    q.add(p);
                }
            }

            if (count >= person.size() && down[0].isEmpty() && down[1].isEmpty()) {
                res = time;
                return;
            }

            for (int i = 0; i < person.size(); i++) {
                if (v[i]) {
                    continue;
                }
                Point p = person.get(i);
                Queue<Point> q = down[p.dist];
                if (q.size() < 3 && time >= p.time + 1) {
                    v[i] = true;
                    p.finish = time + stair[p.dist].gap;
                    q.add(p);
                    count++;
                }
            }
            time++;
        }
    }

    private static int calculateTime(Point p, int stairIndex) {
        return Math.abs(p.x - stair[stairIndex].r) + Math.abs(p.y - stair[stairIndex].c);
    }
}
