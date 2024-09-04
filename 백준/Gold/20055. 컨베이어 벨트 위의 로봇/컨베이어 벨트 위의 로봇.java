import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //문제좀 이해하게 만들어라!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	static int n, k, belt[], step;
	static boolean robot[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		belt = new int[2 * n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n * 2; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		robot = new boolean[n];
		change();
		System.out.println(step);

	}

	private static void change() {
		step = 0;
		while (true) {
			step++;

			// step 1
			// 컨베이어 벨트 이동
			int temp = belt[n * 2 - 1];
			for (int i = 2 * n - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = temp;
			
			// 로봇도 같이 이동? 다음에 이동할건데 왜 이동함 이해안됨
			for (int i = n - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = false;
			robot[n - 1] = false;

			// step 2
			// 로봇 이동
			// 조건이 있대요 바라는것도 겁나게 많아
			// 한칸씩 이동한데요 근데 앞에 이상한 놈이 있거나 내구도가 다닳은 방어구면 안된다네요
			for (int i = n - 1; i > 0; i--) {
				if (belt[i] > 0 && robot[i - 1] && !robot[i]) {
					robot[i] = true;
					robot[i - 1] = false;
					belt[i]--;
					if (robot[n - 1]) {
						robot[n - 1] = false;
					}
				}
			}

			// step 3
			if (belt[0] > 0 && !robot[0]) {
				robot[0] = true;
				belt[0]--;
			}

			// step 4
			int cnt = 0;
			for (int i = 0; i < n * 2; i++) {
				if (belt[i] == 0) {
					cnt++;
				}
				if (cnt >= k) {
					return;
				}
			}
		}

	}
}
