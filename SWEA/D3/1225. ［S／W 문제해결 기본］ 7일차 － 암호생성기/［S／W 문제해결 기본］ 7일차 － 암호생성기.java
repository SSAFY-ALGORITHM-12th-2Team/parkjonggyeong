
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] input;
	static int result, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;

			input = new int[8];
			Queue<Integer> q = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < 8; i++) {
				q.offer(input[i]);

			}
			cnt = 1;
			while (true) {
				int val = q.poll() - cnt;
				if (cnt == 5) {
					cnt = 1;
				} else {
					cnt++;
				}
				
				if (val <= 0) {
					val = 0;
					q.offer(val);
					break;
				} else {
					q.offer(val);
				}
			}

			System.out.print("#" + n);
			for (int i = 0; i < 8; i++) {
				System.out.print(" " + q.poll());
			}
			System.out.println();
		}

	}

}
