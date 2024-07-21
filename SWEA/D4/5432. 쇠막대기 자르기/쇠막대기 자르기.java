import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int cnt = 0;
			int sum = 0;
			String s = sc.next();
			char[] c = new char[s.length()];
			for(int i =0; i < s.length(); i++) {
				c[i] = s.charAt(i);
				Stack<Character> st1 = new Stack<>();
				Stack<Character> st2 = new Stack<>();
				if(c[i] == '(') {
					cnt++;
				}else {
					cnt--;
					
					if(c[i - 1] == '(') {
						sum += cnt;
					}
					else {
						sum++;
					}
				}
			}
			System.out.println("#" + t + " " + sum);
				
		}
	}
}
