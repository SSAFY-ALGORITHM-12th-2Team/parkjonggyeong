import java.io.*;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T, a;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            a =sc.nextInt();
            int s[] = new int[101];
            for(int i = 0; i < 1000; i++) {
                s[sc.nextInt()]++;

            }
                int max = 0;
                int idx = 0;
                for(int i = 100; i > 0; i--){
                    if(s[i] > max){
                        max = s[i];
                        idx = i;
                    }
                }



            System.out.println("#" + a + " " + idx);
        }
    }
}