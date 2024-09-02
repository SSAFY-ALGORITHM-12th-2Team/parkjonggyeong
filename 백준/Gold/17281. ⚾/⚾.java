import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, player[][], maxScore;
    static List<Integer> columns = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        player = new int[n][9];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3번째 열을 제외한 나머지 열을 리스트에 추가
        for (int i = 0; i < 9; i++) {
            if (i != 3) {
                columns.add(i);
            }
        }
        swap1();
        maxScore = 0;
        backtrack(0);
        System.out.println(maxScore);
    }

    private static void backtrack(int depth) {
        if (depth == columns.size()) {
            int score = calculateScore();
            maxScore = Math.max(maxScore, score);
            return;
        }

        // 열의 교환
        for (int i = depth; i < columns.size(); i++) {
            swap(columns.get(depth), columns.get(i));
            backtrack(depth + 1);
            swap(columns.get(depth), columns.get(i)); // 원래 상태로 복구
        }
    }

    private static void swap(int col1, int col2) {
        for (int i = 0; i < n; i++) {
            int temp = player[i][col1];
            player[i][col1] = player[i][col2];
            player[i][col2] = temp;
        }
    }
    private static void swap1() {
        for (int i = 0; i < n; i++) {
            int temp = player[i][0];
            player[i][0] = player[i][3];
            player[i][3] = temp;
        }
    }

    private static int calculateScore() {
        int start = 0;
        int totalScore = 0;

        for (int i = 0; i < n; i++) {
            int out = 0;
            int j = start;
            int score = 0;
            boolean[] base = new boolean[4];

            while (true) {
                if (out == 3) {
                    start = j;
                    break;
                }

                switch (player[i][j]) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            base[3] = true;
                            base[2] = false;
                        }
                        if (base[1]) {
                            base[2] = true;
                        }
                        base[1] = true;
                        break;
                    case 2:
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            score++;
                        }
                        if (base[1]) {
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;
                        break;
                    case 3:
                        if (base[3]) {
                            score++;
                        }
                        if (base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            score++;
                            base[1] = false;
                        }
                        base[3] = true;
                        break;
                    case 4:
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            score++;
                            base[1] = false;
                        }
                        score++;
                        break;
                }

                j++;
                if (j >= 9) {
                    j = 0;
                }
            }
            totalScore += score;
        }

        return totalScore;
    }
}
