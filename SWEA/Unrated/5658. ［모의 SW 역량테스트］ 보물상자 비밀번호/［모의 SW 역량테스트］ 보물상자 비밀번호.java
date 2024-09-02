import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int K = Integer.parseInt(inputs[1]);
            String hexString = br.readLine();

            Set<String> uniqueNumbers = new HashSet<>();
            int sectionLength = N / 4;

            for (int i = 0; i < sectionLength; i++) {
                for (int j = 0; j < 4; j++) {
                    String section = hexString.substring(j * sectionLength, (j + 1) * sectionLength);
                    uniqueNumbers.add(section);
                }
                // Rotate the string
                hexString = hexString.substring(N - 1) + hexString.substring(0, N - 1);
            }

            ArrayList<Integer> sortedNumbers = new ArrayList<>();
            for (String num : uniqueNumbers) {
                sortedNumbers.add(Integer.parseInt(num, 16));
            }
            Collections.sort(sortedNumbers, Collections.reverseOrder());

            int result = sortedNumbers.get(K - 1);
            System.out.println("#" + t + " " + result);
        }
    }
}