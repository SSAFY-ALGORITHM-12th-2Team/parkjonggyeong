import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static ArrayList<Integer>[] list;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		p = new int[n];
		for(int i =0; i< n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		
		int prev = 0;
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += prev + p[i];
			
			prev += p[i];
		}
		System.out.println(sum);
	}
}
