
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, w, l, a[], cnt, weight, point;
	static Queue<Integer> leg, truck;

	static class Truck {
		int weight;

		public Truck(int weight) {
			super();
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 1번줄
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 트럭 수
		w = Integer.parseInt(st.nextToken()); // 다리 길이
		l = Integer.parseInt(st.nextToken()); // 하중
		// 2번줄
		a = new int[w];
		cnt = 0;
		weight = 0;

		st = new StringTokenizer(br.readLine());

		truck = new LinkedList<>(); // 드럭이 들어가는 순서대로
		for (int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}

		leg = new LinkedList<>(); // 다리에 들어가는 순서대로
		for (int i = 0; i < w; i++) {
			leg.add(0);
		}

		bfs();
		System.out.println(cnt);
	}

	private static void bfs() {
		while (!leg.isEmpty()) {
			cnt++;
			weight -= leg.poll();
			if (!truck.isEmpty()) {
				if (truck.peek() + weight <= l) {//트럭이 들어갈수있는지 확인
					int p = truck.poll();
					leg.add(p);
					weight += p;
				} else {// 못들어가면 그냥 0추가
					leg.add(0);
				}
			}
		}
	}
}
