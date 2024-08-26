import java.util.Scanner;

public class Main {
	static int N, col[], ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		col = new int[N + 1];
		setQueens(1);
		System.out.println(ans);
	}

	static void setQueens(int rowNo) {

		if (!isAvailable(rowNo - 1)) {
			return;
		}
		if (rowNo > N) {
			ans++;
			return;
		}

		for (int c = 1; c <= N; c++) {
			col[rowNo] = c;
			setQueens(rowNo + 1);
		}
	}

	private static boolean isAvailable(int rowNo) {
		for (int k = 1; k < rowNo; k++) {
			if (col[rowNo] == col[k] || rowNo - k == Math.abs(col[rowNo] - col[k])) {
				return false;
			}
		}
		return true;
	}
}
