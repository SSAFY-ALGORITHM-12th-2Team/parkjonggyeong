import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int n, sum, num, cn[];
	static String[] input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		input = new String[n];
		for (int i = 0; i < n; i++) {
			input[i] = br.readLine();
		}

		cn = new int[26];
		Arrays.fill(cn, -1);

		maps();

		bw.write(sum + "\n");
		br.close();
		bw.flush();
		bw.close();
	}

	private static void maps() {

		Map<Character, Integer> map = new HashMap<>();
		for (String number : input) {
			int length = number.length();
			for (int i = 0; i < length; i++) {
				char c = number.charAt(i);
				map.put(c, map.getOrDefault(c, 0) + (int) Math.pow(10, length - i - 1));
			}
		}

		List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((a, b) -> b.getValue() - a.getValue());

		num = 9;
		for (int i = 0; i < list.size(); i++) {
			cn[list.get(i).getKey() - 'A'] = num--;
		}

		sum = 0;
		for (int i = 0; i < input.length; i++) {
			int value = 0;
			String number = input[i];
			for (int j = 0; j < number.length(); j++) {
				char[] cnu = number.toCharArray();
				value = value * 10 + cn[cnu[j] - 'A'];
			}
			sum += value;
		}
	}
}