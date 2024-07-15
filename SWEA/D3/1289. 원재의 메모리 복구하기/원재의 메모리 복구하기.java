import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.nextLine();
            char[] b = str.toCharArray();
            char[] e = new char[str.length()];
            Arrays.fill(e, '0');

            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (b[i] != e[i]) {
                    cnt++;
                    char target = b[i];
                    for (int j = i; j < str.length(); j++) {
                        e[j] = target;

                    }

                }
            }

            System.out.println("#" + test_case + " " + cnt);
        }
    }
}
