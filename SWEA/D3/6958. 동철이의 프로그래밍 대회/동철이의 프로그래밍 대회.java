
import java.util.*;

import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int cnt = 0;
			int[] win = new int[n];
			int winner = Integer.MIN_VALUE;
			int[][] p = new int[n][m];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					p[i][j] = sc.nextInt();
					win[i] += p[i][j];
				}
			}
			Arrays.sort(win);
            for (int i = 0; i < n / 2; i++) {
                int temp = win[i];
                win[i] = win[n - i - 1];
                win[n - i - 1] = temp;
            }

			for(int i = 0; i < n; i++) {
				if(winner < win[i]) {
					winner = win[i];
				}else if(winner == win[i]){
					cnt++;
				}
			}
			cnt++;
			System.out.println("#" + t + " " + cnt +" " + winner);
		}
	
	}
}
