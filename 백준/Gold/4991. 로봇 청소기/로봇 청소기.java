import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int h, w;
    static char[][] map;
    static int[][] distance;
    static ArrayList<Node> list;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new char[h][w];
            list = new ArrayList<>();

            for (int i = 0; i < h; i++) {
                String input = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == 'o') {
                        list.add(0, new Node(i, j));
                    } else if (map[i][j] == '*') {
                        list.add(new Node(i, j));
                    }
                }
            }

            int size = list.size();
            distance = new int[size][size];
            boolean reachable = true;

            for (int i = 0; i < size; i++) {
                if (!bfs(list.get(i), i)) {
                    reachable = false;
                    break;
                }
            }

            if (reachable) {
                result = Integer.MAX_VALUE;
                visited = new boolean[size];
                visited[0] = true;
                dfs(0, 1, 0);
                sb.append(result).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }
        System.out.print(sb);
    }

    static boolean bfs(Node startNode, int startIdx) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];
        queue.offer(new Node(startNode.x, startNode.y, 0));
        visited[startNode.x][startNode.y] = true;

        int found = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (map[current.x][current.y] == '*' || map[current.x][current.y] == 'o') {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).x == current.x && list.get(i).y == current.y) {
                        distance[startIdx][i] = current.move;
                        found++;
                    }
                }
            }

            if (found == list.size()) return true;

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (newX >= 0 && newY >= 0 && newX < h && newY < w && map[newX][newY] != 'x' && !visited[newX][newY]) {
                    queue.offer(new Node(newX, newY, current.move + 1));
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    static void dfs(int current, int count, int dist) {
        if (count == list.size()) {
            result = Math.min(result, dist);
            return;
        }

        for (int i = 1; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, count + 1, dist + distance[current][i]);
                visited[i] = false;
            }
        }
    }
}

class Node {
    int x, y, move;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.move = 0;
    }

    Node(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
