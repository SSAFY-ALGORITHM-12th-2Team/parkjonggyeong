
import java.util.*;

import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int up = 0;
			int down = 0;
	
			int[] a = new int[n];
			
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			
			}
			for(int i = 1; i < n; i++) {
				
					up = Math.max(up, (a[i] - a[i - 1]));
		
					down = Math.max(down, (a[i - 1] - a[i]));

	

			}

			System.out.println("#" + t + " " + up + " " + down);

		}
	}
}
