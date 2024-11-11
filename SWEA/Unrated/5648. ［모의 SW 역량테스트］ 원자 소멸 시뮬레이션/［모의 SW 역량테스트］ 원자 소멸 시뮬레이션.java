import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static List<Atom> atom;
    static int dx[] = new int[]{0, 0, -1, 1};
    static int dy[] = new int[]{1, -1, 0, 0};
    static Map<String, List<Atom>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            atom = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int dir = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());
                atom.add(new Atom(x, y, dir, energy));
            }

            int result = solve();
            System.out.println("#" + tc + " " + result);
        }
    }

    static int solve() {
        int sum = 0;
        map = new HashMap<>();

        while (!atom.isEmpty()) {
            map.clear();
            Set<String> collisionSet = new HashSet<>();
            for (Atom a : atom) {
                a.x += dx[a.dir];
                a.y += dy[a.dir];
                if (a.x >= 0 && a.x <= 4000 && a.y >= 0 && a.y <= 4000) {
                    String key = a.x + "," + a.y;
                    if (map.containsKey(key)) {
                        collisionSet.add(key);
                        map.get(key).add(a);
                    } else {
                        map.put(key, new ArrayList<>(Collections.singletonList(a)));
                    }
                }
            }

            List<Atom> remainingAtoms = new ArrayList<>();
            for (Map.Entry<String, List<Atom>> entry : map.entrySet()) {
                List<Atom> atomsAtPosition = entry.getValue();
                if (collisionSet.contains(entry.getKey())) {
                    for (Atom a : atomsAtPosition) {
                        sum += a.energy;
                    }
                } else {
                    remainingAtoms.add(atomsAtPosition.get(0));
                }
            }
            atom = remainingAtoms;
        }
        return sum;
    }

    static class Atom {
        int x, y;
        int dir;
        int energy;

        public Atom(int x, int y, int dir, int energy) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }
    }
}
