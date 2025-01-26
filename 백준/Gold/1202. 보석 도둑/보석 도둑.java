import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static long answer = 0;

    static Integer[] bag;
    static PriorityQueue<Jewelry> jew = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bag = new Integer[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jew.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(bag, (o1, o2) -> o2 - o1);
        jewelry();
        System.out.print(answer);
    }


    public static void jewelry() {
        PriorityQueue<Jewelry> queue = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
        for (int i = k - 1; i >= 0; i--) {
            while (!jew.isEmpty() && bag[i] >= jew.peek().w) {
                queue.add(jew.poll());
            }

            if (!queue.isEmpty()) {
                answer += queue.poll().v;
            }
        }
    }

    static class Jewelry implements Comparable<Jewelry> {
        int v;
        int w;

        public Jewelry(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Jewelry o) {
            if (this.w == o.w) return o.v - this.v;
            return this.w - o.w;
        }
    }
}
