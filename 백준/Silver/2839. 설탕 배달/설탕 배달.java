import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int count = 0;

		while (n > 0) {
			if (n % 5 == 0) {
				count += n / 5;
				break;
			} else {
				n -= 3;
				count++;
			}
			if (n < 0)
				count = -1;
		}
		System.out.println(count);
	}
}
