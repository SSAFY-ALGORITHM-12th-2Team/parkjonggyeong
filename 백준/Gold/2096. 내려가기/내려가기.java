import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        maxD = new int[n][3];
        minD = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int n;
    static int arr[][];
    static int minD[][];
    static int maxD[][];

    public static void main(String[] args) throws IOException {
        input();
        dp();
    }

    private static void dp() {
        minD[0][0] = maxD[0][0] = arr[0][0];
        minD[0][1] = maxD[0][1] = arr[0][1];
        minD[0][2] = maxD[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            minD[i][0] = Math.min(minD[i - 1][0], minD[i - 1][1]) + arr[i][0];
            minD[i][1] = Math.min(Math.min(minD[i - 1][0], minD[i - 1][1]), minD[i - 1][2]) + arr[i][1];
            minD[i][2] = Math.min(minD[i - 1][1], minD[i - 1][2]) + arr[i][2];

            maxD[i][0] = Math.max(maxD[i - 1][0], maxD[i - 1][1]) + arr[i][0];
            maxD[i][1] = Math.max(Math.max(maxD[i - 1][0], maxD[i - 1][1]), maxD[i - 1][2]) + arr[i][1];
            maxD[i][2] = Math.max(maxD[i - 1][1], maxD[i - 1][2]) + arr[i][2];
        }
        System.out.print(Math.max(Math.max(maxD[n - 1][0], maxD[n - 1][1]), maxD[n - 1][2]));
        System.out.println(" "+Math.min(Math.min(minD[n - 1][0], minD[n - 1][1]), minD[n - 1][2]));

    }
}