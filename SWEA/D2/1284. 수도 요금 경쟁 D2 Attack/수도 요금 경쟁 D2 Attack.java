import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T, p, q, r, s, w;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            int a = 0;
            int b = 0;
            p = sc.nextInt(); //a사 p돈
            q = sc.nextInt(); //b사 기본요금 q, 월간사용량 r이상은 1리터당 s의 요금
            r = sc.nextInt();
            s = sc.nextInt();
            w = sc.nextInt(); // 총사용량

            a = w * p;

            if (r >= w) {
                b = q;
            } else {
               b = q + (w - r) * s;

            }
            result = Math.min(a, b);

            System.out.println("#" + test_case + " " + result);
        }
    }
}